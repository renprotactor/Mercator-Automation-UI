<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                <title>Surefire Report</title>
            </head>
            <body>
                <h1>Surefire Report</h1>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>Test Name</th>
                        <th>Status</th>
                        <th>Duration</th>
                    </tr>
                    <xsl:for-each select="//testcase">
                        <tr>
                            <td><xsl:value-of select="@classname"/>.<xsl:value-of select="@name"/></td>
                            <td>
                                <xsl:choose>
                                    <xsl:when test="failure">Failed</xsl:when>
                                    <xsl:when test="error">Error</xsl:when>
                                    <xsl:otherwise>Passed</xsl:otherwise>
                                </xsl:choose>
                            </td>
                            <td><xsl:value-of select="@time"/> seconds</td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>