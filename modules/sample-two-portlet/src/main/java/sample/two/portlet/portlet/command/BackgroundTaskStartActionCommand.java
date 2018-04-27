package sample.two.portlet.portlet.command;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import sample.api.api.SampleService;
import sample.two.portlet.constants.SampleTwoPortletKeys;

@Component(
    property = {
        "javax.portlet.name=" + SampleTwoPortletKeys.PORTLET_ID,
        "mvc.command.name=" + BackgroundTaskStartActionCommand.COMMAND_NAME
    },
    service = MVCActionCommand.class
)
public class BackgroundTaskStartActionCommand extends BaseMVCActionCommand {

  public static final String COMMAND_NAME = "StartBackgroundTask";

  @Override
  protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {

    ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

    SessionMessages.add(actionRequest,
        SampleTwoPortletKeys.PORTLET_ID + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);

    try {
      long backgroundTaskId = _sampleService.doSomething(
          themeDisplay.getUserId(), themeDisplay.getScopeGroupId());
      actionResponse.setRenderParameter("backgroundTaskId", String.valueOf(backgroundTaskId));
    } catch (PortalException e) {
      _log.error("Failed on doSomething");
    }

  }

  private static final Log _log = LogFactoryUtil.getLog(BackgroundTaskStartActionCommand.class);

  @Reference
  private SampleService _sampleService;
}
