package sample.service.internal.background.task;

import static com.liferay.portal.kernel.backgroundtask.BackgroundTaskConstants.STATUS_FAILED;
import static com.liferay.portal.kernel.backgroundtask.BackgroundTaskConstants.STATUS_IN_PROGRESS;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskConstants;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import org.osgi.service.component.annotations.Component;
import sample.service.internal.background.task.constants.SampleConstants;
import sample.service.internal.background.task.constants.SimplifiedBackGroundTaskConstants;

@Component(
    immediate = true,
    property = {
        "background.task.executor.class.name=" + SampleConstants.SIMPLIFIED_BG_CLASSNAME
    },
    service = BackgroundTaskExecutor.class
)
public class SimplifiedBackGroundTaskExecutor extends BaseBackgroundTaskExecutor {

  public SimplifiedBackGroundTaskExecutor() {
    setBackgroundTaskStatusMessageTranslator(new SimplifiedBackGroundTaskMessageTranslator());
    setIsolationLevel(BackgroundTaskConstants.ISOLATION_LEVEL_NOT_ISOLATED);
  }

  @Override
  public BackgroundTaskExecutor clone() {
    return new SimplifiedBackGroundTaskExecutor();
  }

  @Override
  public BackgroundTaskResult execute(BackgroundTask backgroundTask) throws Exception {
    long id = backgroundTask.getBackgroundTaskId();
    String logMessage =
        String.format("  >>  Simplified task %d started: %d", id, System.nanoTime());

    _log.info(logMessage);

    int millisForSleep = 30000;
    int increment = 1000;
    int current = 0;

    double timeToFail = Math.random() * millisForSleep * 3; // fail about a third of the time

    while (current < millisForSleep) {
      updateStatus(id, ((double) current / millisForSleep));
      Thread.sleep(increment);
      current += increment;
      if (current > timeToFail) {
        updateStatus(id, ((double) current / millisForSleep), true);
        throw new PortalException("Sample Portal Execption");
      }
    }
    logMessage = String.format("  >>  Simplified task %d complete", id);
    _log.info(logMessage);

    return BackgroundTaskResult.SUCCESS;
  }

  private void updateStatus(long id, double completionValue) {
    updateStatus(id, completionValue, false);
  }

  private void updateStatus(long id, double completionValue, boolean failed) {
    Message message = new Message();

    message.put(BackgroundTaskConstants.BACKGROUND_TASK_ID, id);
    message.put(SimplifiedBackGroundTaskConstants.PROGRESS, completionValue);
    message.put(
        SimplifiedBackGroundTaskConstants.STATUS, failed ? STATUS_FAILED : STATUS_IN_PROGRESS);

    MessageBusUtil.sendMessage(DestinationNames.BACKGROUND_TASK_STATUS, message);
  }

  @Override
  public BackgroundTaskDisplay getBackgroundTaskDisplay(BackgroundTask backgroundTask) {
    return new SimplifiedBackGroundTaskDisplay(backgroundTask);
  }

  private static Log _log = LogFactoryUtil.getLog(SimplifiedBackGroundTaskExecutor.class);
}
