package sample.api.api;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author sgm
 */
public interface SampleService {

  long doSomething(long userId, long groupId) throws PortalException;

  int getPercentageComplete(long backgroundTaskId);

}