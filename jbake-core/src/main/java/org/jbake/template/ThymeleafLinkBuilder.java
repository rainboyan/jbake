package org.jbake.template;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.context.IWebContext;
import org.thymeleaf.linkbuilder.StandardLinkBuilder;

public class ThymeleafLinkBuilder extends StandardLinkBuilder {
    protected String computeContextPath(
            final IExpressionContext context, final String base, final Map<String, Object> parameters) {

        if (context instanceof IWebContext) {
			// If it is context-relative, it has to be a web context
			final HttpServletRequest request = ((IWebContext)context).getRequest();
			return request.getContextPath();
        } else {
			return "/";
        }

    }
}