package com.springmvc.dao;

import com.springmvc.entities.*;
import static com.springmvc.entities.UserEntity.newEntity;
import com.springmvc.models.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.ParameterMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<UserInfo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo getById(int id) {
		UserInfo user = new UserInfo();

		try {
			Session session = sessionFactory.getCurrentSession();

			UserEntity authorEntity = (UserEntity) session.get(UserEntity.class, id);

			user.entity2model(authorEntity);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public int save(UserInfo userInfo) {
		int userId = -1;
		
		try {
			Session session = sessionFactory.getCurrentSession();
			
			UserEntity entity = newEntity(userInfo);
			RoleEntity role = (RoleEntity)session.get(RoleEntity.class, 1);
			Set<RoleEntity> roles = new HashSet<RoleEntity>();
			roles.add(role);
			entity.setRoles(roles);
			
			session.save(entity);
			
			userId = entity.getUser_id();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userId;
	}

	@Override
	public boolean update(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getFullName(int id) {
		String fullName = "";

		try {
			Session session = sessionFactory.getCurrentSession();

			ProcedureCall spQuery = session.createStoredProcedureCall("sp_User_getFullName");
			spQuery.registerParameter("id", Integer.class, ParameterMode.IN);
			spQuery.setParameter("id", id);

			fullName = (String) spQuery.getResultList().get(0);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return fullName;
	}

	@Override
	public List<Role> checkLogin(String email, String password) {
		List<Role> roles = new ArrayList<Role>();

		try {
			Session session = sessionFactory.getCurrentSession();

			ProcedureCall spQuery = session.createStoredProcedureCall("sp_User_checkLogin", RoleEntity.class);
			spQuery.registerParameter("email", String.class, ParameterMode.IN).bindValue(email);
			spQuery.registerParameter("password", String.class, ParameterMode.IN).bindValue(password);

			@SuppressWarnings("unchecked")
			List<RoleEntity> listRE = (List<RoleEntity>)spQuery.getResultList();
			
			for (int i = 0; i < listRE.size(); i++) {
				Role role = new Role();
				role.entity2model(listRE.get(i));
				roles.add(role);
			}

		} catch (Exception e) {
			e.printStackTrace();
			roles = null;
		}
		return roles;
	}

	@Override
	public int getIdByEmail(String email) {
		int id = -1;
		try {
			Session session = sessionFactory.getCurrentSession();

			ProcedureCall spQuery = session.createStoredProcedureCall("sp_User_getIdByEmail");
			spQuery.registerParameter("email", String.class, ParameterMode.IN).bindValue(email);

			id = (int)spQuery.getResultList().get(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			id = -1;
		}
		return id;
	}
}
