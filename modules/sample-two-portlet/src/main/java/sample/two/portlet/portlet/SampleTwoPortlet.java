package sample.two.portlet.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import java.io.IOException;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceURL;
import org.osgi.service.component.annotations.Component;
import sample.two.portlet.constants.SampleTwoPortletKeys;
import sample.two.portlet.portlet.command.BackgroundTaskStartActionCommand;
import sample.two.portlet.portlet.command.BackgroundTaskStatusResourceCommand;

/**
 * @author sgm
 */
@Component(
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=category.sample",
        "javax.portlet.display-name=sample-two-portlet Portlet",
        "javax.portlet.name=" + SampleTwoPortletKeys.PORTLET_ID,
        "javax.portlet.security-role-ref=power-user,user",
        "javax.portlet.supported-public-render-parameter="
            + SampleTwoPortlet.SOME_RENDERED_PARAMETER,
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/view.jsp",
    },
    service = Portlet.class
)
public class SampleTwoPortlet extends MVCPortlet {

  @Override
  public void render(RenderRequest renderRequest, RenderResponse renderResponse)
      throws IOException, PortletException {

    int randomValue = (int) (Math.random() * 10000);
    String someValue = String.valueOf(randomValue);

    long backgroundTaskId = ParamUtil.getLong(renderRequest, "backgroundTaskId");

    if (backgroundTaskId != 0) {
      addResourceCommandUrl(renderRequest, renderResponse, backgroundTaskId);
    }

    renderRequest.setAttribute("backgroundTaskId", backgroundTaskId);
    renderRequest.setAttribute("someValue", someValue);

    addStartTaskUrl(renderRequest, renderResponse);

    super.render(renderRequest, renderResponse);

  }

  private void addStartTaskUrl(RenderRequest renderRequest, RenderResponse renderResponse) {
    PortletURL actionURL = renderResponse.createActionURL();
    actionURL.setParameter("javax.portlet.action", BackgroundTaskStartActionCommand.COMMAND_NAME);
    renderRequest.setAttribute("startTaskActionUrl", actionURL);
  }

  private void addResourceCommandUrl(RenderRequest renderRequest, RenderResponse renderResponse,
      long backgroundTaskId) {
    ResourceURL resourceURL = renderResponse.createResourceURL();
    resourceURL.setParameter(
        "p_p_resource_id", BackgroundTaskStatusResourceCommand.PERCENT_RES_CMD);

    resourceURL.setParameter("backgroundTaskId", String.valueOf(backgroundTaskId));

    renderRequest.setAttribute("statusResourceUrl", resourceURL.toString());
  }

  static final String SOME_RENDERED_PARAMETER = "someRenderedParameter";

  private static final Log _log = LogFactoryUtil.getLog(SampleTwoPortlet.class);

}