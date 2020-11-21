jQuery(document).ready(function(){ 	
    $.ajax({
        url : 'http://localhost:8080/Tp5ExemplesCours/users', 
        type : 'GET', 
        dataType : 'json',

        success : function(data, statut){ 

           $.each(data, function(key,value){
            var li = document.createElement("li");
            li.innerHTML = "Nom : "+value.nom+", Prenom : "+value.prenom+", age : "+value.age;
            $("#users").append(li);
           });
        }
     });


    
});