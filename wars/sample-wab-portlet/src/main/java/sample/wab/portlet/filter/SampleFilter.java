package sample.wab.portlet.filter;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import java.io.IOException;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.RenderFilter;

public class SampleFilter implements RenderFilter {

  @Override
  public void doFilter(RenderRequest request, RenderResponse response, FilterChain chain)
      throws IOException, PortletException {
    _log.info ("Made it into the custom filter");
    chain.doFilter(request, response);
    String someRenderedParameter = request.getParameter("someRenderedParameter");
    _log.info(">> someRenderedParameter = \"" + someRenderedParameter + "\"");
//    String nonPublicParameter = request.getParameter("nonPublicParameter");
//    _log.info(">> nonPublicParameter = \"" + nonPublicParameter + "\"");
  }

  @Override
  public void init(FilterConfig filterConfig) throws PortletException {

  }

  @Override
  public void destroy() {

  }

  private Log _log = LogFactoryUtil.getLog(SampleFilter.class);
}
