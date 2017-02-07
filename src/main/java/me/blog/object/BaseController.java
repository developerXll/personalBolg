package me.blog.object;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseController {
	protected Log logger = LogFactory.getLog(this.getClass());
	
	protected void log(String msg) {
		logger.warn(msg);
	}
}
