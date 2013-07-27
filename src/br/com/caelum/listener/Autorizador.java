package br.com.caelum.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.caelum.notasfiscais.mb.LoginBean;

public class Autorizador implements PhaseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
		String pagina = context.getViewRoot().getViewId();
		System.out.println(pagina);
		if(pagina.equals("/login.xhtml")){
			return ;
		}
		LoginBean loginBean=context.getApplication()
				.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
		if(!loginBean.isLogado()){
			NavigationHandler handler=context.getApplication().getNavigationHandler();
			handler.handleNavigation(context, null, "login?faces-redirect=true");
			context.renderResponse();
		}
		
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		System.out.println("Depois da Fase:"+event.getPhaseId());
		
	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return PhaseId.RESTORE_VIEW;
	}
}