<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"  xmlns="https://www.diamondss.com/"   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <origin>
            <xsl:variable name="xmlns" select="/gem/@xmlns"/>

            <xsl:attribute name="xmlns"><xsl:value-of select="$xmlns"/></xsl:attribute>
            <xsl:for-each select="/gem/gemstone">
                <gemstone>
                    <name>
                        <xsl:value-of   select="./name"/>
                    </name>
                    <preciousness>
                        <xsl:value-of   select="./preciousness"/>
                    </preciousness>
                    <origin>
                        <xsl:value-of   select="./origin"/>
                    </origin>
                    <VisualParameters>
                        <color>
                            <xsl:value-of   select="./VisualParameters/color"/>
                        </color>
                        <transparency>
                            <xsl:value-of   select="./VisualParameters/transparency"/>
                        </transparency>
                        <cutting>
                            <xsl:value-of   select="./VisualParameters/cutting"/>
                        </cutting>
                    </VisualParameters>
                    <value>
                        <xsl:value-of   select="./value"/>
                    </value>
                </gemstone>
            </xsl:for-each>
        </origin>
    </xsl:template>
</xsl:stylesheet>