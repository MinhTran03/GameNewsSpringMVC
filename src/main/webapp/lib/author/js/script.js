//==============================================================================

function createElement(type, ...nClassName) {
   let element = document.createElement(type);
   for (className of nClassName) {
      element.classList.add(className);
   }

   return element;
}

function createChip(tagName) {
   let chip = createElement("div", "chip");
   let closeIcon = createElement("i", "close", "fas", "fa-times");
   closeIcon.addEventListener('click', (event) => {
      event.target.parentElement.parentElement.removeChild(event.target.parentElement);
   });
   chip.innerText = tagName;
   chip.append(closeIcon);
   return chip;
}

let chips = document.getElementsByClassName('chips');
let btnAddChip = document.getElementsByClassName('btn btn-outline-secondary');
let inputTagName = document.getElementsByClassName('form-control');
let tagsNameExist = document.getElementsByClassName('chip');
let btnsDeleteTag = document.getElementsByClassName('close fas fa-times');

// add event remove for existed tag
(function () {
   for (let i = 0; i < btnsDeleteTag.length; i++) {
      btnsDeleteTag[i].addEventListener('click', (event) => {
         chips[0].removeChild(event.target.parentElement);
      })
   }
})();

function isAddChip(tagName) {
   for (tagNameCheck of tagsNameExist) {
      if (tagNameCheck.innerText === tagName) {
         return false;
      }
   }
   return true;
}

function addChip(tagName) {
   if (isAddChip(tagName)) {
      let chip = createChip(tagName);
      chips[0].append(chip);
      return true;
   }
   return false;
}

btnAddChip[0].addEventListener('click', (event) => {
   let tagName = event.target.parentElement.previousElementSibling.value;
   if (addChip(tagName)) {
      event.target.parentElement.previousElementSibling.value = '';
   }
});

inputTagName[1].addEventListener('keyup', (event) => {
   if (event.keyCode === 13) {
      if (addChip(event.target.value)) {
         event.target.value = '';
      }
   }
})