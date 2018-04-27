package sample.service.internal;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskManager;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import java.util.HashMap;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import sample.api.api.SampleService;
import sample.service.internal.background.task.SimplifiedBackGroundTaskDisplay;
import sample.service.internal.background.task.constants.SampleConstants;

/**
 * @author Shanon Mathai
 */
@Component(
    service = SampleService.class,
    immediate = true
)
public class SampleServiceImpl implements SampleService {

  public SampleServiceImpl() {
    _log.info("  Initializing Sample Service: " + System.nanoTime());
  }

  @Override
  public long doSomething(long userId, long groupId) throws PortalException {

    BackgroundTask someTask = _backgroundTaskManager.addBackgroundTask(
        userId, groupId, "someTask", SampleConstants.SIMPLIFIED_BG_CLASSNAME,
        new HashMap<>(), null);

    return someTask.getBackgroundTaskId();
  }

  @Override
  public int getPercentageComplete(long backgroundTaskId) {
    BackgroundTask backgroundTask = _backgroundTaskManager.fetchBackgroundTask(backgroundTaskId);

    if (backgroundTask == null) {
      return -2;
    }

    SimplifiedBackGroundTaskDisplay taskDisplay =
        new SimplifiedBackGroundTaskDisplay(backgroundTask);

    return taskDisplay.getPercentage();
  }

  private static final Log _log = LogFactoryUtil.getLog(SampleServiceImpl.class);

  @Reference
  private BackgroundTaskManager _backgroundTaskManager;

}