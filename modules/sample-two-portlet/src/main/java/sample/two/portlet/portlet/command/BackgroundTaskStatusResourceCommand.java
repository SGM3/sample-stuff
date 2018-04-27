package sample.two.portlet.portlet.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import java.io.PrintWriter;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import sample.api.api.SampleService;
import sample.two.portlet.constants.SampleTwoPortletKeys;

@Component(
    property = {
        "javax.portlet.name=" + SampleTwoPortletKeys.PORTLET_ID,
        "mvc.command.name=" + BackgroundTaskStatusResourceCommand.PERCENT_RES_CMD
    },
    service = MVCResourceCommand.class
)
public class BackgroundTaskStatusResourceCommand extends BaseMVCResourceCommand {

  public static final String PERCENT_RES_CMD = "get_background_percentage";

  @Override
  protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
      throws Exception {

    long backgroundTaskId = ParamUtil.getLong(resourceRequest, "backgroundTaskId");

    PrintWriter printWriter = new PrintWriter(resourceResponse.getPortletOutputStream());

    int percentageComplete = _sampleService.getPercentageComplete(backgroundTaskId);

    printWriter.print(percentageComplete);
    printWriter.flush();
    printWriter.close();
  }

  @Reference
  private SampleService _sampleService;
}
