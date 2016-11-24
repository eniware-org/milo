/*
 * Copyright (c) 2016 Kevin Herron
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v1.0 which accompany this distribution.
 *
 * The Eclipse Public License is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 *   http://www.eclipse.org/org/documents/edl-v10.html.
 */

package org.eclipse.milo.opcua.sdk.server.model.nodes.objects;

import java.util.Optional;

import org.eclipse.milo.opcua.sdk.server.api.ServerNodeMap;
import org.eclipse.milo.opcua.sdk.server.api.nodes.VariableNode;
import org.eclipse.milo.opcua.sdk.server.model.nodes.variables.PropertyNode;
import org.eclipse.milo.opcua.sdk.server.model.types.objects.AuditCertificateDataMismatchEventType;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.QualifiedName;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UByte;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;

@org.eclipse.milo.opcua.sdk.core.annotations.UaObjectNode(typeName = "0:AuditCertificateDataMismatchEventType")
public class AuditCertificateDataMismatchEventNode extends AuditCertificateEventNode implements AuditCertificateDataMismatchEventType {

    public AuditCertificateDataMismatchEventNode(
        ServerNodeMap nodeMap,
        NodeId nodeId,
        QualifiedName browseName,
        LocalizedText displayName,
        LocalizedText description,
        UInteger writeMask,
        UInteger userWriteMask,
        UByte eventNotifier) {

        super(nodeMap, nodeId, browseName, displayName, description, writeMask, userWriteMask, eventNotifier);
    }

    @Override
    public String getInvalidHostname() {
        Optional<String> property = getProperty(AuditCertificateDataMismatchEventType.INVALID_HOSTNAME);

        return property.orElse(null);
    }

    @Override
    public PropertyNode getInvalidHostnameNode() {
        Optional<VariableNode> propertyNode = getPropertyNode(AuditCertificateDataMismatchEventType.INVALID_HOSTNAME.getBrowseName());

        return propertyNode.map(n -> (PropertyNode) n).orElse(null);
    }

    @Override
    public void setInvalidHostname(String value) {
        setProperty(AuditCertificateDataMismatchEventType.INVALID_HOSTNAME, value);
    }

    @Override
    public String getInvalidUri() {
        Optional<String> property = getProperty(AuditCertificateDataMismatchEventType.INVALID_URI);

        return property.orElse(null);
    }

    @Override
    public PropertyNode getInvalidUriNode() {
        Optional<VariableNode> propertyNode = getPropertyNode(AuditCertificateDataMismatchEventType.INVALID_URI.getBrowseName());

        return propertyNode.map(n -> (PropertyNode) n).orElse(null);
    }

    @Override
    public void setInvalidUri(String value) {
        setProperty(AuditCertificateDataMismatchEventType.INVALID_URI, value);
    }

}
