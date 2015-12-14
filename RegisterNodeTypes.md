#This page describes how to register node types in the repository

# Introduction #

When you using application specific node types and namespaces, you have to register them in the workspace(?repository).


# Details #

With jackrabbit registering custom node types in very easy. First you have define the custom  node type definitions in CND notation or XML notation. Following code sample shows how those node types defined in the file can be registered.

```
    Workspace ws = session.getWorkspace();   	
    NodeTypeManagerImpl ntTypeMgr = (NodeTypeManagerImpl)ws.getNodeTypeManager();
    InputStream inputStream = getServletContext().getResourceAsStream(cndPath);                                                              
    ntTypeMgr.registerNodeTypes(inputStream,JackrabbitNodeTypeManager.TEXT_X_JCR_CND,true);

    InputStream nodeTypeStream = getServletContext().getResourceAsStream(ocmPath);
    ntTypeMgr.registerNodeTypes(nodeTypeStream,JackrabbitNodeTypeManager.TEXT_XML,true);

```


Registering the namespaces also can be done in a similar manner.

```
    NamespaceRegistryImpl nsReg = (NamespaceRegistryImpl)session.getWorkspace().getNamespaceRegistry();
    nsReg.safeRegisterNamespace("demo","http://code.google.com/p/jackrabbit-jcr-demo");
```