# springSOAP

This is a simple implementation of an spring soap project which contains a server with a endpoint that exposes a service called 
get-user which returns a object User using the field "name" as parameter.
The project also contains two implementation of spring soap clients (spring-soap-client-wsdl-remote && spring-soap-client-wsdl-local), one that uses a remote wsdl file for generating the domain classes and other that uses a wsdl embeded into resource package. Both clients point to the server described above.
