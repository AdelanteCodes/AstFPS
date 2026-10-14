# Fcitx5 Enhancer

Review status: **Evidence inventory; behavioral review pending**

Project: [Fcitx5 Enhancer](https://modrinth.com/mod/fcitx5-enhancer)
Selected artifact version: `0.2.14`
Published implementation source: https://github.com/NLR-DevTeam/Fcitx5-Enhancer
Artifact acquisition: Downloaded; hashes verified

## Purpose and applicability

A simple mod that enhances Fcitx5 users' experience.

This catalogue description is publisher-stated. It does not establish an FPS gain or unchanged behavior.

Client support: `required`. Server support: `unsupported`.

Artifact identity:
- `sha1`: `e60ccbd0485da72d84105a87f68b7f76d153bf11`
- `sha512`: `bef34814860d3163c23b454a3497bba57ff7812480dcc8e9d2a4b7317d755e1797b43fd054340b73656a13951766110f41ef9572b1c6e69b04541e13d3a58c46`

## Mechanism review still needed

The interface and symbol map below identify where the implementation attaches. They are extracted evidence, not a substitute for reading the control flow. Do not treat this entry as a completed understanding.

- Trace initialization and each hot-path hook to the helper methods it calls.
- Establish cache keys, ownership, invalidation, reload, world-change, and shutdown behavior where applicable.
- Distinguish saved work from removed visual/gameplay behavior, scheduling changes, or configuration presets.
- Check exceptions, fallback, thread handoffs, and interactions with other hooks.
- Compare complete output/state with the original behavior before using an idea in AstFPS.

## Loader interface

Top-level bytecode classes: 172
Reconstructed Java files: 145

**environment**

```json
"client"
```

**entrypoints**

```json
{
  "modmenu": [
    "cn.xiaym.fcitx5.compat.ModMenuEntry"
  ]
}
```

**depends**

```json
{
  "minecraft": [
    ">=26.3"
  ],
  "cloth-config": "*"
}
```

## Embedded components

Top-level source counts do not include these components. Their presence is not evidence that their implementation has been reviewed.

| Archive | Classes | Component ID | Reconstructed separately |
|---|---:|---|---|
| `META-INF/jars/fcitx5-enhancer-26.3-0.2.14.jar` | 24 | `fcitx5-enhancer-26-3` | Reconstructed source; semantic review pending |

## Implementation navigation

Automatically extracted symbols from reconstructed source. Missing methods, generated bridge methods, and decompiler artifacts are possible. Source-file hashes identify the exact local reconstruction.

| Component / source file | Mixin target | Hook kinds | Declared method names |
|---|---|---|---|
| top-level / `cn/xiaym/fcitx5/dbus/Fcitx5Controller1.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/dbus/Fcitx5DBus.java` | `` |  | tryInit, disconnectOnError, checkDBus, getState, getStateAsync, activate, deactivate |
| top-level / `cn/xiaym/fcitx5/deps/dbus/annotations/DBusBoundProperty.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/annotations/DBusIgnore.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/annotations/DBusInterfaceName.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/annotations/DBusMemberName.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/annotations/DBusProperties.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/annotations/DBusProperty.java` | `` |  | getAccessName |
| top-level / `cn/xiaym/fcitx5/deps/dbus/annotations/MethodNoReply.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/annotations/Position.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/annotations/PropertiesEmitsChangedSignal.java` | `` |  | toString |
| top-level / `cn/xiaym/fcitx5/deps/dbus/ArrayFrob.java` | `` |  | getPrimitiveToWrapperTypes, getWrapperToPrimitiveTypes, wrap, unwrap, listify, listify, delist, delistprimitive, convert, type |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/AbstractConnection.java` | `` |  | createReaderThread, findMatchingTypes, setWeakReferences, exportObject, exportObject, addFallback, removeFallback, removeSigHandler, removeSigHandler, addSigHandler, addSigHandler, assertSignal, addSigHandlerWithoutMatch, callWithCallback, callMethodAsync, createTypesArray, queueCallback, isFileDescriptorSupported |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/base/AbstractConnectionBase.java` | `` |  | internalDisconnect, disconnect, disconnect, rejectUnknownProperty, doWithExportedObjectsAndReturn, doWithExportedObjects, getLogger, getFallbackContainer, getAddress, isConnected, getTransport, sendMessage, sendMessageInternally, getExportedObject, getError, connect, getTransportConfig, listen, getMessageFactory, getPendingErrorQueue, getHandledSignals, getGenericHandledSignals, getPendingCalls, getImportedObjects, getObjectTree, getCallbackManager, getReceivingService, getBusAddress, getInfoMap, getConnectionConfig, unExportObject, getCallInfo, getDisconnectCallback, setDisconnectCallback, close, toString |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/base/ConnectionMessageHandler.java` | `` |  | handleException, handleMessage, handleMessage, run, handleMessage, run, handleMessage |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/base/ConnectionMethodInvocation.java` | `` |  | queueInvokeMethod, setupAndInvoke, invokeMethodAndReply, invokedMethodReply, invokeMethod |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/base/DBusBoundPropertyHandler.java` | `` |  | handleDBusBoundProperties, handleGetAll, handleGet, handleSet |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/base/FallbackContainer.java` | `` |  | add, remove, get |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/base/GlobalHandler.java` | `` |  | isRemote, Ping, Introspect, getObjectPath, GetMachineId |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/base/IncomingMessageThread.java` | `` |  | terminate, run |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/base/PendingCallbackManager.java` | `` |  | queueCallback, removeCallback, getCallback, getCallbackReply |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/base/ReceivingService.java` | `` |  | shutdown, shutdownNow |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/BusAddress.java` | `` |  | of, of, getType, getBusType, isBusType, isListeningSocket, getGuid, toString, isServer, addParameter, removeParameter, hasParameter, getParameterValue, getParameterValue, getListenerAddress |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/config/ReceivingServiceConfig.java` | `` |  | getSignalThreadPoolSize, getErrorThreadPoolSize, getMethodCallThreadPoolSize, getMethodReturnThreadPoolSize, getSignalThreadPriority, getMethodCallThreadPriority, getErrorThreadPriority, getMethodReturnThreadPriority, getRetryHandler |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/config/ReceivingServiceConfigBuilder.java` | `` |  | handle, withSignalThreadCount, withErrorHandlerThreadCount, withMethodCallThreadCount, withMethodReturnThreadCount, withSignalThreadPriority, withErrorThreadPriority, withMethedCallThreadPriority, withMethodReturnThreadPriority, withRetryHandler, build, connectionConfig, getDefaultConfig, getDefaultRetryHandler |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/config/SaslConfig.java` | `` |  | getMode, setMode, getAuthMode, setAuthMode, getGuid, setGuid, getSaslUid, setSaslUid, isStrictCookiePermissions, setStrictCookiePermissions, isFileDescriptorSupport, setFileDescriptorSupport, toString |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/config/SaslConfigBuilder.java` | `` |  | back, withAuthMode, withSaslUid, withStrictCookiePermissions, build |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/config/TransportConfig.java` | `` |  | getBusAddress, setBusAddress, setListening, isListening, getPreConnectCallback, setPreConnectCallback, getAfterBindCallback, setAfterBindCallback, isAutoConnect, setAutoConnect, getTimeout, setTimeout, getFileOwner, setFileOwner, getFileGroup, setFileGroup, getFileUnixPermissions, setFileUnixPermissions, getAdditionalConfig, setAdditionalConfig, getSaslConfig, getEndianess, setEndianess, isRegisterSelf, setRegisterSelf, getServiceLoaderClassLoader, setServiceLoaderClassLoader, getServiceLoaderModuleLayer, setServiceLoaderModuleLayer |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/config/TransportConfigBuilder.java` | `` |  | withConfig, withBusAddress, getBusAddress, withPreConnectCallback, withAfterBindCallback, withAutoConnect, withRegisterSelf, configureSasl, withListening, withTimeout, withUnixSocketFileOwner, withUnixSocketFileGroup, withUnixSocketFilePermissions, withAdditionalConfig, withServiceLoaderClassLoader, withServiceLoaderModuleLayer, withRemoveAdditionalConfig, withEndianess, back, build |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/IDisconnectAction.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/IDisconnectCallback.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/impl/BaseConnectionBuilder.java` | `` |  | buildThreadConfig, buildTransportConfig, getConnectionConfig, receivingThreadConfig, transportConfig, withWeakReferences, withExportWeakReferences, withImportWeakReferences, withDisconnectCallback, withUnknownSignalHandler, getSystemEndianness |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/impl/ConnectionConfig.java` | `` |  | isExportWeakReferences, setExportWeakReferences, isImportWeakReferences, setImportWeakReferences, getDisconnectCallback, setDisconnectCallback, getUnknownSignalHandler, setUnknownSignalHandler |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/impl/DBusConnection.java` | `` |  | getConcurrentConnections, register, doWithBusNamesAndReturn, doWithBusNames, dynamicProxy, getExportedObject, getExportedObject, releaseBusName, requestBusName, getUniqueName, getNames, getDBusOwnerName, getPeerRemoteObject, getRemoteObject, getRemoteObject, removeSigHandler, removeSigHandler, removeSigHandler, addSigHandler, addSigHandler, validateSignal, addSigHandler, disconnect, close, getMachineId, removeGenericSigHandler, addGenericSigHandler, handle |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/impl/DBusConnectionBuilder.java` | `` |  | forSessionBus, forSystemBus, forSessionBus, forType, forType, forAddress, forAddress, validateTransportAddress, withShared, build, getSharedConnection |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/impl/IRemoteObjectGetter.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/SASL.java` | `` |  | findCookie, addCookie, stupidlyEncode, stupidlyEncode, getNibble, stupidlyDecode, receive, send, convertAuthTypes, auth, isFileDescriptorSupported, handleReject, getUserId, getCommand, getMechs, getData, getResponse, setResponse, toString |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/shared/ExecutorNames.java` | `` |  | getDescription, toString |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/shared/IThreadPoolRetryHandler.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/transports/AbstractTransport.java` | `` |  | writeMessage, readMessage, isConnected, connect, isListening, listen, internalConnect, setPreConnectCallback, authenticate, createInputOutput, runCallback, getAddress, getLogger, getSaslConfig, getTransportConnection, getMessageFactory, getTransportConfig, isFileDescriptorSupported, toString, close |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/transports/AbstractUnixTransport.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/transports/IFileBasedBusAddress.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/transports/TransportBuilder.java` | `` |  | create, create, create, create, createWithDynamicSession, configure, build, getAddress, getRegisteredBusTypes, createDynamicSession, getAuthMode |
| top-level / `cn/xiaym/fcitx5/deps/dbus/connections/transports/TransportConnection.java` | `` |  | getChannel, getWriter, getReader, getSocketProviderImpl, getId, getMessageFactory, toString, close |
| top-level / `cn/xiaym/fcitx5/deps/dbus/Container.java` | `` |  | setup, getParameters, toString, equals, hashCode |
| top-level / `cn/xiaym/fcitx5/deps/dbus/DBusAsyncReply.java` | `` |  | checkReply, hasReply, getReply, toString, getMethod, getConnection, getCall |
| top-level / `cn/xiaym/fcitx5/deps/dbus/DBusCallInfo.java` | `` |  | getSource, getDestination, getObjectPath, getInterface, getMethod, getFlags |
| top-level / `cn/xiaym/fcitx5/deps/dbus/DBusMatchRule.java` | `` |  | getCachedSignalType, matches, matches, toString, hashCode, equals, getType, getInterface, getMember, getSource, getObject |
| top-level / `cn/xiaym/fcitx5/deps/dbus/DBusPath.java` | `` |  | getPath, setPath, getSource, toString, hashCode, equals, compareTo, of |
| top-level / `cn/xiaym/fcitx5/deps/dbus/errors/InvalidMethodArgument.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/errors/MatchRuleInvalid.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/errors/NoReply.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/errors/UnknownMethod.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/errors/UnknownObject.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/errors/UnknownProperty.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/exceptions/AddressResolvingException.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/exceptions/AuthenticationException.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/exceptions/ClassOutsideOfPackageException.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/exceptions/DBusException.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/exceptions/DBusExecutionException.java` | `` |  | setType, getType |
| top-level / `cn/xiaym/fcitx5/deps/dbus/exceptions/DBusTypeConversationRuntimeException.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/exceptions/FatalDBusException.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/exceptions/IllegalThreadPoolStateException.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/exceptions/InvalidBusAddressException.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/exceptions/InvalidBusNameException.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/exceptions/InvalidInterfaceSignature.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/exceptions/InvalidObjectPathException.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/exceptions/InvalidSignalException.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/exceptions/MarshallingException.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/exceptions/MessageFormatException.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/exceptions/MessageProtocolVersionException.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/exceptions/MessageTypeException.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/exceptions/MissingInterfaceImplementationException.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/exceptions/NotConnected.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/exceptions/SocketClosedException.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/exceptions/TransportConfigurationException.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/exceptions/TransportRegistrationException.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/exceptions/UnknownTypeCodeException.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/FileDescriptor.java` | `` |  | toJavaFileDescriptor, getIntFileDescriptor, equals, hashCode, toString, fromJavaFileDescriptor |
| top-level / `cn/xiaym/fcitx5/deps/dbus/interfaces/CallbackHandler.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/interfaces/DBus.java` | `` |  | toString, toString, toString |
| top-level / `cn/xiaym/fcitx5/deps/dbus/interfaces/DBusInterface.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/interfaces/DBusSerializable.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/interfaces/DBusSigHandler.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/interfaces/FatalException.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/interfaces/Introspectable.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/interfaces/NonFatalException.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/interfaces/Peer.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/interfaces/Properties.java` | `` |  | getInterfaceName, getPropertiesChanged, getPropertiesRemoved, toString |
| top-level / `cn/xiaym/fcitx5/deps/dbus/Marshalling.java` | `` |  | getDBusType, convertJavaClassesToSignature, convertToSig, getDBusType, getDBusType, recursiveGetDBusType, getJavaType, convertParameters, convertParameters, deSerializeParameters |
| top-level / `cn/xiaym/fcitx5/deps/dbus/messages/DBusSignal.java` | `` |  | createSignalClass, createReal, cacheConstructors, appendbody, matchesParameters, createTypes, wrap |
| top-level / `cn/xiaym/fcitx5/deps/dbus/messages/EmptyCollectionHelper.java` | `` |  | determineSignatureOffsetStruct, determineEndOfBracketStructure, determineSubSignature, determineCollectionSubType |
| top-level / `cn/xiaym/fcitx5/deps/dbus/messages/Error.java` | `` |  | createExceptionClass, getException, throwException |
| top-level / `cn/xiaym/fcitx5/deps/dbus/messages/ExportedObject.java` | `` |  | generateAnnotationsXml, generatePropertyXml, generatePropertyXml, generatePropertiesXml, generateMethodsXml, createReturnArguments, generateSignalsXml, getDBusInterfaces, generateIntrospectionXml, getMethods, getPropertyMethods, getObject, getIntrospectiondata, getImplementedInterfaces, toString, isExcluded |
| top-level / `cn/xiaym/fcitx5/deps/dbus/messages/Message.java` | `` |  | updateEndianess, getHeader, setHeader, getByteCounter, setByteCounter, setSerial, setWireData, preallocate, ensureBuffers, appendBytes, appendByte, demarshallint, appendint, marshallint, getWireData, getFiledescriptors, toString, getHeader, pad, append, appendOne, align, readHeaderVariants, extractOne, extractByte, extractStruct, extractArray, extractVariant, optimizePrimitives, prepareCollection, extract, extract, getSource, getDestination, getInterface, getPath, getName, getSig, getFlags, getSerial, getReplySerial, getParameters, getParameters, extractArgs, setArgs, setSource, getType, getEndianess, createHeaderArgs, padAndMarshall, demarshallint, demarshallintBig, demarshallintLittle, marshallintBig, marshallintLittle, getAlignment, getHeaderFieldName |
| top-level / `cn/xiaym/fcitx5/deps/dbus/messages/MessageFactory.java` | `` |  | getEndianess, createSignal, createSignal, createMethodCall, createMethodCall, createMethodReturn, createMethodReturn, createError, createError, createError, createError, createMessage |
| top-level / `cn/xiaym/fcitx5/deps/dbus/messages/MethodBase.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/messages/MethodCall.java` | `` |  | setDefaultTimeout, hasReply, getReply, getReply, setReply |
| top-level / `cn/xiaym/fcitx5/deps/dbus/messages/MethodReturn.java` | `` |  | getCall, setCall |
| top-level / `cn/xiaym/fcitx5/deps/dbus/messages/ObjectTree.java` | `` |  | recursiveFind, recursiveAdd, add, recursiveRemove, remove, Introspect, recursivePrint, toString |
| top-level / `cn/xiaym/fcitx5/deps/dbus/MethodTuple.java` | `` |  | hashCode, equals, getLogger, getName, getSig |
| top-level / `cn/xiaym/fcitx5/deps/dbus/ObjectPath.java` | `` |  | getSource, setSource, hashCode, equals |
| top-level / `cn/xiaym/fcitx5/deps/dbus/propertyref/PropertyRef.java` | `` |  | hashCode, equals, getName, getType, getAccess, getEmitChangeSignal, accessForMethod, typeForMethod, checkMethod |
| top-level / `cn/xiaym/fcitx5/deps/dbus/propertyref/PropRefRemoteHandler.java` | `` |  | handleDBusBoundProperty, getPropertiesMethod |
| top-level / `cn/xiaym/fcitx5/deps/dbus/RemoteInvocationHandler.java` | `` |  | getRemote, invoke, convertRV, convertRV, executeRemoteMethod, executeRemoteMethod, executeRemoteMethod |
| top-level / `cn/xiaym/fcitx5/deps/dbus/RemoteObject.java` | `` |  | equals, hashCode, isAutostart, getBusName, getObjectPath, getInterface, toString |
| top-level / `cn/xiaym/fcitx5/deps/dbus/spi/message/AbstractInputStreamMessageReader.java` | `` |  | readMessage, getLogger, getSocketProviderImpl, close, isClosed, toString |
| top-level / `cn/xiaym/fcitx5/deps/dbus/spi/message/AbstractOutputStreamMessageWriter.java` | `` |  | writeMessage, getLogger, getSocketProviderImpl, close, isClosed, toString |
| top-level / `cn/xiaym/fcitx5/deps/dbus/spi/message/DefaultSocketProvider.java` | `` |  | createReader, createWriter, setFileDescriptorSupport, isFileDescriptorPassingSupported |
| top-level / `cn/xiaym/fcitx5/deps/dbus/spi/message/IMessageReader.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/spi/message/IMessageWriter.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/spi/message/InputStreamMessageReader.java` | `` |  | readFileDescriptors |
| top-level / `cn/xiaym/fcitx5/deps/dbus/spi/message/ISocketProvider.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/spi/message/OutputStreamMessageWriter.java` | `` |  | writeFileDescriptors |
| top-level / `cn/xiaym/fcitx5/deps/dbus/spi/transport/ITransportProvider.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/StrongReference.java` | `` |  | clear, enqueue, get |
| top-level / `cn/xiaym/fcitx5/deps/dbus/Struct.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/transport/jre/NativeTransportProvider.java` | `` |  | getTransportName, createTransport, getSupportedBusType, createDynamicSessionAddress |
| top-level / `cn/xiaym/fcitx5/deps/dbus/transport/jre/NativeUnixSocketHelper.java` | `` |  | getUid |
| top-level / `cn/xiaym/fcitx5/deps/dbus/transport/jre/NativeUnixSocketTransport.java` | `` |  | hasFileDescriptorSupport, connectImpl, bindImpl, acceptImpl, isBound, closeTransport, getUid |
| top-level / `cn/xiaym/fcitx5/deps/dbus/transport/jre/UnixBusAddress.java` | `` |  | hasPath, getPath, updatePermissions |
| top-level / `cn/xiaym/fcitx5/deps/dbus/Tuple.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/TypeRef.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/types/DBusListType.java` | `` |  | getActualTypeArguments, getRawType, getOwnerType, toString |
| top-level / `cn/xiaym/fcitx5/deps/dbus/types/DBusMapType.java` | `` |  | getActualTypeArguments, getRawType, getOwnerType, toString |
| top-level / `cn/xiaym/fcitx5/deps/dbus/types/DBusStructType.java` | `` |  | getActualTypeArguments, getRawType, getOwnerType |
| top-level / `cn/xiaym/fcitx5/deps/dbus/types/UInt16.java` | `` |  | byteValue, doubleValue, floatValue, intValue, longValue, shortValue, equals, hashCode, compareTo, toString |
| top-level / `cn/xiaym/fcitx5/deps/dbus/types/UInt32.java` | `` |  | byteValue, doubleValue, floatValue, intValue, longValue, shortValue, equals, hashCode, compareTo, toString |
| top-level / `cn/xiaym/fcitx5/deps/dbus/types/UInt64.java` | `` |  | value, byteValue, doubleValue, floatValue, intValue, longValue, shortValue, equals, hashCode, compareTo, toString, top, bottom |
| top-level / `cn/xiaym/fcitx5/deps/dbus/types/Variant.java` | `` |  | getValue, getType, getSig, toString, hashCode, equals |
| top-level / `cn/xiaym/fcitx5/deps/dbus/utils/AddressBuilder.java` | `` |  | getSystemConnection, getSessionConnection, getDbusMachineId, determineMachineIdFile, getFakeDbusMachineId, createMachineId |
| top-level / `cn/xiaym/fcitx5/deps/dbus/utils/CommonRegexPattern.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/utils/DBusNamingUtil.java` | `` |  | getInterfaceName, getMethodName, getPropertyName, getSignalName, getAnnotationName |
| top-level / `cn/xiaym/fcitx5/deps/dbus/utils/DBusObjects.java` | `` |  | requireBase, requirePackage, requireDBusInterface, requireObjectPath, requireObjectPath, requirePackage, requireDBusInterface, requireObjectPath, requireObjectPath, requireBusName, requireBusName, requireNotBusName, requireConnectionId, requireBusNameOrConnectionId, validateBusName, validateNotBusName, validateObjectPath, validateDBusInterface, validateClassHasPackage, validateNotObjectPath, validateNotConnectionId, validateConnectionId, requireNotNull, ensurePublicInterfaces |
| top-level / `cn/xiaym/fcitx5/deps/dbus/utils/Hexdump.java` | `` |  | toHex, toHex, toHex, toAscii, toAscii, format, format, print, print, print, print, toByteArray, toByteArray |
| top-level / `cn/xiaym/fcitx5/deps/dbus/utils/IThrowingConsumer.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/utils/IThrowingFunction.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/utils/IThrowingSupplier.java` | `` |  |  |
| top-level / `cn/xiaym/fcitx5/deps/dbus/utils/LoggingHelper.java` | `` |  | arraysVeryDeepString, arraysVeryDeepStringRecursive, logIf |
| top-level / `cn/xiaym/fcitx5/deps/dbus/utils/NameableThreadFactory.java` | `` |  | newThread |
| top-level / `cn/xiaym/fcitx5/deps/dbus/utils/PrimitiveUtils.java` | `` |  | getPrimitiveToWrapperTypes, getWrapperToPrimitiveTypes, isCompatiblePrimitiveOrWrapper |
| top-level / `cn/xiaym/fcitx5/deps/dbus/utils/ReflectionFileDescriptorHelper.java` | `` |  | getFileDescriptorValue, createFileDescriptor, createInstance, getInstance |
| top-level / `cn/xiaym/fcitx5/deps/dbus/utils/TimeMeasure.java` | `` |  | reset, getStartTime, getElapsed, getElapsedSeconds, getElapsedFormatted, getElapsedAndReset, toString |
| top-level / `cn/xiaym/fcitx5/deps/dbus/utils/Util.java` | `` |  | readProperties, readProperties, isBlank, strEquals, isEmpty, randomString, upperCaseFirstChar, snakeToCamelCase, abbreviate, isValidNetworkPort, isValidNetworkPort, isInteger, readFileToList, readFileToString, getTextfileFromUrl, readTextFileFromStream, writeTextFile, getHostName, collectionContainsAny, getCurrentUser, isMacOs, isFreeBsd, isWindows, getJavaVersion, genGUID, createDynamicSessionAddress, checkIntInRange, setFilePermissions, waitFor, unwrapTypeRef, toObjectArray, defaultString, getConstructor |
| top-level / `cn/xiaym/fcitx5/Fcitx5.java` | `` |  | userTyping, shouldInterceptPreventKey, noteUserInput, disarmEndKeyGrace, onNativeTypingStateChanged |
| META-INF/jars/fcitx5-enhancer-26.3-0.2.14.jar / `cn/xiaym/fcitx5/compat/ModMenuEntry.java` | `` |  | getModConfigScreenFactory |
| META-INF/jars/fcitx5-enhancer-26.3-0.2.14.jar / `cn/xiaym/fcitx5/config/BuiltinRuleSet.java` | `` |  | getTranslation, applyConfig, screenRuleShouldBlock, getElementRule, RuleSetBinding, applyConfig |
| META-INF/jars/fcitx5-enhancer-26.3-0.2.14.jar / `cn/xiaym/fcitx5/config/ModConfig.java` | `` |  | serializeElementRule, serializeScreenRule, register, loadConfig, saveConfig, createScreen, getElementRule, getOrCreateElementRule, getOrCreateScreenRule, updateList, screenRuleShouldBlock |
| META-INF/jars/fcitx5-enhancer-26.3-0.2.14.jar / `cn/xiaym/fcitx5/config/rules/ElementRule.java` | `` |  | ElementRule, create, modifyShouldBlock |
| META-INF/jars/fcitx5-enhancer-26.3-0.2.14.jar / `cn/xiaym/fcitx5/config/rules/ScreenRule.java` | `` |  | ScreenRule, create, modifyShouldBlock |
| META-INF/jars/fcitx5-enhancer-26.3-0.2.14.jar / `cn/xiaym/fcitx5/config/UserRuleListSqrEntry.java` | `` |  | self, getSimpleClassName, getValue, getError, getCellHeight, extractRenderState, updateNarration, children, narrationPriority, handleDeletion |
| META-INF/jars/fcitx5-enhancer-26.3-0.2.14.jar / `cn/xiaym/fcitx5/GlobalState.java` | `` |  |  |
| META-INF/jars/fcitx5-enhancer-26.3-0.2.14.jar / `cn/xiaym/fcitx5/IMBlockerListener.java` | `` |  | onScreenOpen, onElementFocus, suppress, tryActivate, tryDeactivate, dispatchAsync, dispatchAsyncConditional, ensureConsistency |
| META-INF/jars/fcitx5-enhancer-26.3-0.2.14.jar / `cn/xiaym/fcitx5/Main.java` | `` |  | tryLoadLibrary, setScreen, getScreen, getToastManager, onInitializeClient |
| META-INF/jars/fcitx5-enhancer-26.3-0.2.14.jar / `cn/xiaym/fcitx5/MixinPlugin.java` | `` |  | shouldApplyMixin, onLoad, getRefMapperConfig, acceptTargets, getMixins, preApply, postApply |
| META-INF/jars/fcitx5-enhancer-26.3-0.2.14.jar / `cn/xiaym/fcitx5/mixins/EditBoxMixin.java` | `value={EditBox.class})` | Inject:2 | disableOnCommand, onWrite, onSetText |
| META-INF/jars/fcitx5-enhancer-26.3-0.2.14.jar / `cn/xiaym/fcitx5/mixins/GuiMixin.java` | `value={Gui.class})` | Inject:2, WrapOperation:1 | checkBlocker, setScreen, openChatScreen, wrapRender |
| META-INF/jars/fcitx5-enhancer-26.3-0.2.14.jar / `cn/xiaym/fcitx5/mixins/KeyboardHandlerMixin.java` | `value={KeyboardHandler.class})` | Inject:2 | keyShouldBeIntercepted, onKey, onChar |
| META-INF/jars/fcitx5-enhancer-26.3-0.2.14.jar / `cn/xiaym/fcitx5/mixins/MinecraftMixin.java` | `value={Minecraft.class})` | Inject:2 | onInit, onTickEnd |
| META-INF/jars/fcitx5-enhancer-26.3-0.2.14.jar / `cn/xiaym/fcitx5/mixins/MouseHandlerMixin.java` | `value={MouseHandler.class})` | Inject:3, WrapOperation:1 | onMouseButton, onMouseClickedElement, onMouseScroll, onFilesDropped |
| META-INF/jars/fcitx5-enhancer-26.3-0.2.14.jar / `cn/xiaym/fcitx5/screen/ElementRuleEditScreen.java` | `` |  | getYesOrNoText, createRemoveButton, nullSafe, init, extractRenderState, onClose |
| META-INF/jars/fcitx5-enhancer-26.3-0.2.14.jar / `cn/xiaym/fcitx5/screen/IncompatibleNoticeScreen.java` | `` |  | init, extractRenderState, onClose |
| META-INF/jars/fcitx5-enhancer-26.3-0.2.14.jar / `cn/xiaym/fcitx5/screen/ScreenRuleEditScreen.java` | `` |  | init, extractRenderState, onClose |

## Verification boundary

Static research only. No runtime behavior, visual equivalence, compatibility guarantee, or FPS increase is established by this note. Publisher claims and implementation observations are kept separate.
