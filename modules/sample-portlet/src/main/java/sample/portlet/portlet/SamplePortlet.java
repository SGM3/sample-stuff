package sample.portlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.portlet.Portlet;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;
import sample.portlet.constants.SamplePortletKeys;

/**
 * @author sgm
 */
@Component(
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=category.sample",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=sample-portlet Portlet",
        "javax.portlet.name=" + SamplePortletKeys.Sample,
        "javax.portlet.security-role-ref=power-user,user",
        "javax.portlet.supported-public-render-parameter=" + SamplePortlet.SOME_RENDERED_PARAMETER
    },
    service = Portlet.class
)
public class SamplePortlet extends MVCPortlet {

  @Override
  public void render(RenderRequest renderRequest, RenderResponse renderResponse)
      throws IOException {

    PortletURL renderURL = renderResponse.createRenderURL();

    renderURL.setParameter(SOME_RENDERED_PARAMETER, "SomeValue");
    renderURL.setParameter(NON_PUBLIC_PARAMETER, "SomeOtherValue");

    String renderUrlString = renderURL.toString();

    PrintWriter printWriter = renderResponse.getWriter();

    printWriter.print("<a href=" + renderUrlString + ">" + renderUrlString + "</a>");
  }

  static final String SOME_RENDERED_PARAMETER = "someRenderedParameter";

  private static final String NON_PUBLIC_PARAMETER = "nonPublicParameter";
}