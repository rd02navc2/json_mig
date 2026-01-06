<?xml version="1.0" encoding="UTF-8"?>
<!--DOCTYPE xsl:stylesheet [ <!ENTITY nbsp "&#160;"> ]-->
<!-- ===================================================================== -->

<xsl:stylesheet version="2.0" 
	 xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	 xmlns:xsd="http://www.w3.org/2001/XMLSchema"
	 xmlns:fn="http://www.w3.org/2005/02/xpath-functions"
	 xmlns:xdt="http://www.w3.org/2005/02/xpath-datatypes"
	 xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2"> 

<xsl:template match="/">
	<html>
	<body>
	<p>
		<font face="arial, helvetica, sans-serif size=4">
			<xsl:value-of select ="xsd:Name"/>
		</font>	
	</p>
	
	<table border= "1">
	
	<caption>
		<font face="arial, helvetica, sans-serif size=4">
		<xsl:value-of select="../@targetNamespace"/>
		</font>
	</caption>
		
	<!-- Print heading-->
	<thead>
		<tr>
			<th align="center">Value</th>
			<th align="center">Name</th>
			<th align="center">Definition</th>
		</tr>
	</thead>
	
	<!-- Print Declaration-->
		<!-- Same code as following FOR loop (start)-->	
		
		<!-- Print WCOID  ; '&#160;'  is nonbreaking space-->
	<tbody>
		<xsl:for-each select="//xsd:enumeration">

		<tr>

			<!-- Print Value -->
			 <td align="center">
				 <font face="arial, helvetica, sans-serif size=4">
					<xsl:value-of select ="@value"/>
				</font>
			</td>

			<!-- Print Name -->
			 <td align="center">
				 <font face="arial, helvetica, sans-serif size=4">
					<xsl:value-of select ="./xsd:annotation/xsd:documentation/ccts:Name"/>
				</font>
			</td>

			<!-- Print Definition -->
			<td>
				<font face="arial, helvetica, sans-serif size=4">
					 <xsl:value-of select ="./xsd:annotation/xsd:documentation/ccts:Definition"/>
				</font>	 
			</td>
		</tr>
		</xsl:for-each>
	</tbody>
	</table>

	</body>
	</html>
</xsl:template>

</xsl:stylesheet> 
 
