package biebInterceptors;

import java.util.Map;

import biebDomain.User;
import biebDomain.UserRole;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class CoworkerInterceptor implements Interceptor {

	public void destroy() {
	}

	public void init() {
	}

	public String intercept( ActionInvocation actionInvocation ) throws Exception {

		@SuppressWarnings("rawtypes")
		Map session = actionInvocation.getInvocationContext().getSession();
		try{
			User user = (User) session.get("user");

			if (user.getUr().equals(UserRole.Coworker)) {
				return actionInvocation.invoke();
			} 
			else {
				return Action.LOGIN;
			}
		} catch(NullPointerException npe){
			return Action.LOGIN;
		}

	}
}
