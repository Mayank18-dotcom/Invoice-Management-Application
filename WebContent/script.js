// Searchbox JS
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});

// Add Button JS
var addBtn = document.querySelector('.add-btn');
var addBg = document.querySelector('.add-bg');
var addClose = document.querySelector('.add-close');
addBtn.addEventListener('click',function(){
  addBg.classList.add('bg-add');  
});

addClose.addEventListener('click' , function(){
	addBg.classList.remove('bg-add');
})

// Edit Button JS
var editBtn = document.querySelector('.edit-btn');
var editBg = document.querySelector('.edit-bg');
var editClose = document.querySelector('.edit-close');
editBtn.addEventListener('click',function(){
  editBg.classList.add('bg-edit');  
});

editClose.addEventListener('click' , function(){
	editBg.classList.remove('bg-edit');
})


// Del Button JS
var delBtn = document.querySelector('.del-btn');
var delBg = document.querySelector('.del-bg');
var delClose = document.querySelector('.del-close');
delBtn.addEventListener('click',function(){
  delBg.classList.add('bg-del');  
});

delClose.addEventListener('click' , function(){
	delBg.classList.remove('bg-del');
})