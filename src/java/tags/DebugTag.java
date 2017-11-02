/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *s
 * @author 727153
 */
public class DebugTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        ServletRequest request = pageContext.getRequest();
        String debug = request.getParameter("debug");
        if (debug != null && debug.isEmpty() && (request.getServerName().startsWith("test.")||request.getServerName().equals("localhost")))
        {
            return EVAL_BODY_INCLUDE;
        }
        return SKIP_BODY;
    }
    
}