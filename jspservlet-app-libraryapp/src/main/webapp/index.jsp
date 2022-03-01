<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
	<title>Placement details</title>

<title>Placement Management Application</title>
	<jsp:include page="include/header.jsp"></jsp:include>
	<style> 
	body {
	  background-image: url('db3c2tc.jpg');
	  opacity:1;
	  background-repeat: no-repeat;
	  background-attachment: fixed;
	  background-size: cover;
	}</style>
		
	</head>>
	<body>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
			  <a class="navbar-brand" href="#">Navbar</a>
			  <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			  </button>
			  <div class="collapse navbar-collapse" id="navbarSupportedContent">
				<form class="d-flex">
				  <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
				  <button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			  </div>
			</div>
		  </nav>
	<center>
	    <h1 style="color:white;">Add Placement</h1>
        <h2 style="font-family: Tahoma, Verdana, sans-serif; margin-top: 2%;">
         <a href="book?action=new" class="btn btn-warning" style="color:white;"> Add new Book</a>
        <a href="book?action=list" class="btn btn-warning" style="color:white;"> Display Book Details</a>
        
        </h2>
        </center>
	 <div align="center">
	
		<c:if test="${book != null}">
			<form action="book?action=update" method="post">
        </c:if>
        <c:if test="${book == null}">
			<form action="book?action=insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
  
            	<h2 style="color:white;">
            		<c:if test="${book != null}">
            			Edit Book
            		</c:if>
            		<c:if test="${book== null}">
            			Add New Book
            		</c:if>
            	</h2>
          
                    <c:if test="${book != null}">
        			<input type="hidden" name="id" value="<c:out value='${book.id}' />" />
        		</c:if>            
            <tr>
                <th style="color:white;">Book Name: </th>
                <td>
                	<input type="text" name="name" size="45"
                			value="<c:out value='${placement.name}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th style="color:white;"> Author Name: </th>
                <td>
                	<input type="text" name="book" size="45"
                			value="<c:out value='${placement.college}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th style="color:white;">Book Description </th>
                <td>
                	<input type="text" name="date" size="45"
                			value="<c:out value='${placement.date}' />"
                	/>
                </td>
            </tr>
            
           
            <tr>
            	<td colspan="2" align="center">
            		<button type="submit" class="btn btn-warning" style="color:white;">Save</button>
            	</td>
            </tr>
        </table>
        </form>
       </div>	
       
</body>
</html>