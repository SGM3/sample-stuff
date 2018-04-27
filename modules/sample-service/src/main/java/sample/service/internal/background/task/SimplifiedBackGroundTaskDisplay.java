package sample.service.internal.background.task;

import static sample.service.internal.background.task.constants.SimplifiedBackGroundTaskConstants.PROGRESS;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskConstants;
import com.liferay.portal.kernel.backgroundtask.display.BaseBackgroundTaskDisplay;
import com.liferay.portal.kernel.template.TemplateResource;
import java.util.Map;

public class SimplifiedBackGroundTaskDisplay extends BaseBackgroundTaskDisplay {

  public SimplifiedBackGroundTaskDisplay(
      BackgroundTask backgroundTask) {
    super(backgroundTask);
  }

  @Override
  public int getPercentage() {
    int status = backgroundTask.getStatus();
    switch (status) {
      case BackgroundTaskConstants.STATUS_QUEUED:
        return 0;
      case BackgroundTaskConstants.STATUS_SUCCESSFUL:
        return 100;
      case BackgroundTaskConstants.STATUS_FAILED:
        return -1;
      default:
        double completion = (Double) backgroundTaskStatus.getAttribute(PROGRESS);
        return (int) (completion * 100);
    }
  }

  @Override
  protected TemplateResource getTemplateResource() {
    return null;
  }

  @Override
  protected Map<String, Object> getTemplateVars() {
    return null;
  }
}
