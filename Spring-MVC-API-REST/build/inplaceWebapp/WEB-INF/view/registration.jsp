<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
    uri="http://www.springframework.org/tags/form"%>


<html>
<header>

</header>
    <body>
        <h1>S'inscrire</h1>
        <form:form modelAttribute="registration">

            <label for="ipseudo">Entrez votre pseudo : </label>
            <form:input path="pseudo" type="text" id="ipseudo" /><br>

            <label for="iemail">Entrez votre adresse mail : </label>
            <form:input path="email" type="mail" id="iemail" /><br>

            <label for="imdp">Entrez un mot de passe : </label>
            <input type="password" id="imdp" required><br>

            <input type="submit" value="m'inscrire">

            <form:errors path="*" cssClass="errorblock" element="div"/>
        </form:form>
    </body>
</html>