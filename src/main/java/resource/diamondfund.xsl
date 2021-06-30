<!--<?xml version="1.0" encoding="UTF-8"?>-->
<!--<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"-->
<!--                xmlns:m="https://diamondss.com/">-->
<!--<xsl:output method="xml"/>-->

<!--<xsl:template match="m:gem">-->
<!--    <origin>-->
<!--        <xsl:apply-templates/>-->
<!--    </origin>-->
<!--</xsl:template>-->

<!--<xsl:template match="m:gemstone">-->
<!--    <xsl:element name="gemstone">-->
<!--        <xsl:attribute name="name">-->
<!--            <xsl:value-of select="@name"/>-->
<!--        </xsl:attribute>-->
<!--        <preciousness><xsl:value-of select="m:preciousness"/></preciousness>-->
<!--        <xsl:element name="visual_param">-->
<!--            <color><xsl:value-of select="m:visual_param/m:color"/></color>-->
<!--            <transparency><xsl:value-of select="m:visual_param/m:transparency"/></transparency>-->
<!--            <cutting><xsl:value-of select="m:visual_param/m:cutting"/></cutting>-->
<!--        </xsl:element>-->
<!--        <value><xsl:value-of select="m:value"/></value>-->
<!--    </xsl:element>-->
<!--</xsl:template>-->
<!--</xsl:stylesheet>-->