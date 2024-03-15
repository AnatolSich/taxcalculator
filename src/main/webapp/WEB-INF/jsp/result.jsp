<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Tax</title>
<link rel="stylesheet" href="css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

	<header id="home" class="header">
		<nav class="nav" role="navigation">
			<div class="container nav-elements">
				<ul class="navbar">
            <ul class="navbar">
                <li><a href="/home">home</a></li>
                <li><a href="/goToTax">calculate</a></li>
                            </ul><!-- navbar -->
				<!-- navbar -->
			</div>
			<!-- container nav-elements -->
		</nav>
	</header>
	<!-- #home -->

<!--FORM FOR calculation -->
	<section id="search" class="section">
		<header class="imageheader"></header>
		<div class="container">
			<h2 class="headline">Calculate your taxes</h2>
			<form action="/tax" method="get">
				<label class="card-title">Pls input your Gross Annual Salary</label>
				 <input path="salary" name="salary" value="">
			    <input type="submit" value="submit">
			</form>
		</div>
	</section>
	<!-- guarantee -->



   <c:if test="${!empty(results)}">
    		<section id="people" class="section">
    		<header class="imageheader"></header>
                		<div class="container">
                			<h2 class="headline">Results</h2>
            <c:forEach var="result" items="${results}">

    		<div class="resultContainer">

            				<div class="resultContainerItem">
            				    <table border="1">
                                    <tr>
                                        <th>Item</th>
                                        <th>Amount</th>
                                    </tr>
            				        <tr>
                                        <td><p>Gross Annual Salary</p></td>
                                        <td> <input  type="text" name="Gross Annual Salary" value="${result.grossAnnualSalary}"></td>
                                    </tr>
                                    <tr>
                                        <td><p>Gross Monthly Salary</p></td>
                                        <td> <input  type="text" name="Gross Monthly Salary" value="${result.grossMonthlySalary}"></td>
                                    </tr>
                                    <tr>
                                        <td><p>Net Annual Salary</p></td>
                                        <td> <input  type="text" name="Net Annual Salary" value="${result.netAnnualSalary}"></td>
                                    </tr>
                                    <tr>
                                        <td><p>Net Monthly Salary</p></td>
                                        <td> <input  type="text" name="Net Monthly Salary" value="${result.netMonthlySalary}"></td>
                                    </tr>
                                    <tr>
                                        <td><p>Annual Tax Paid</p></td>
                                        <td> <input  type="text" name="Annual Tax Paid" value="${result.annualTaxPaid}"></td>
                                    </tr>
                                    <tr>
                                        <td><p>Monthly Tax Paid</p></td>
                                        <td> <input  type="text" name="Monthly Tax Paid" value="${result.monthlyTaxPaid}"></td>
                                    </tr>
                                </table>
            				</div>

            </c:forEach>
            		</div>

            </section>
            </c:if>

	<section id="history" class="section">
		<div class="container">
			<div class="text-content">
				<h2 class="headline">Company History</h2>
				<p>
					We have very long history.
				</p>
			</div>
		</div>
		<!-- container text -->
	</section>


<footer class="footer">
    <div class="container">
        <nav class="nav" role="navigation">
            <div class="container nav-elements">
                <div class="branding">
                    <p class="address">Please<br>
                        use our help!
                    </p>
                </div>
            </div>
        </nav>
        <p class="legal">Information provided about the product is fictitious and should not be representative on the market.</p>
    </div><!-- container -->
</footer><!-- footer -->




</body>
</html>