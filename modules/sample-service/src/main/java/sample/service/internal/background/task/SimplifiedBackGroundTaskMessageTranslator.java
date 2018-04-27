package sample.service.internal.background.task;

import static com.liferay.portal.kernel.backgroundtask.BackgroundTaskConstants.BACKGROUND_TASK_ID;
import static sample.service.internal.background.task.constants.SimplifiedBackGroundTaskConstants.PROGRESS;
import static sample.service.internal.background.task.constants.SimplifiedBackGroundTaskConstants.STATUS;

import com.liferay.portal.kernel.backgroundtask.BackgroundTaskConstants;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskStatus;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskStatusMessageTranslator;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;

public class SimplifiedBackGroundTaskMessageTranslator implements
    BackgroundTaskStatusMessageTranslator {

  @Override
  public void translate(BackgroundTaskStatus backgroundTaskStatus, Message message) {

    long backgroundTaskId = message.getLong(BACKGROUND_TASK_ID);
    int status = message.getInteger(STATUS);
    double completion = message.getDouble(PROGRESS);

    String statusLabel = BackgroundTaskConstants.getStatusLabel(status);
    //"executing for"
    String logMessage =
        String.format("  >>  Simplified task %d %s: %.2f %% completion", backgroundTaskId,
            statusLabel, completion * 100);
    backgroundTaskStatus.setAttribute(PROGRESS, completion);
    _log.info(logMessage);
  }

  private Log _log = LogFactoryUtil.getLog(SimplifiedBackGroundTaskMessageTranslator.class);
}
