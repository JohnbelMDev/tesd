<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
  <h1> Add Book Form</h1>
  <form action="<%= request.getContextPath() %>/AddBookServlet" method="post">
   <table style="with: 80%">
    <tr>
     <td>Isbn</td>
     <td><input type="text" name="isbn" /></td>
    </tr>
    <tr>
     <td>Title</td>
     <td><input type="text" name="title" /></td>
    </tr>
    <tr>
     <td>Editor</td>
     <td><input type="text" name="editor" /></td>
    </tr>
    <tr>
     <td>Edition</td>
     <td><input type="text" name="edition" /></td>
    </tr>
    <tr>
    <td>Year</td>
     <td><input type="Text" name="year" /></td>
     </tr>
     <tr>
    <td>Author First Name</td>
     <td><input type="Text" name="authorFirstName" /></td>
     </tr>
     <tr>
    <td>Author Last Name</td>
     <td><input type="Text" name="authorLastName" /></td>
     </tr>
    <tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>