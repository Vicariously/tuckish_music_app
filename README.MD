Application context will contain beans for the root webapp. This should include application-wide beans such as datasources, business objects etc.

Servlet context will contain beans for the servlet app context. This should include controllers etc.

There can be multiple servlet contexts to one application context. In the future if we expand this application they can all extend the same application context.

Beans in servlet.xml can reference beans in the application context, but not the other way around.

