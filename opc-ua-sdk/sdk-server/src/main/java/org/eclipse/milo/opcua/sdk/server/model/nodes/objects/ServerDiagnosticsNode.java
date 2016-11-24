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
import org.eclipse.milo.opcua.sdk.server.api.nodes.ObjectNode;
import org.eclipse.milo.opcua.sdk.server.api.nodes.VariableNode;
import org.eclipse.milo.opcua.sdk.server.model.nodes.variables.PropertyNode;
import org.eclipse.milo.opcua.sdk.server.model.nodes.variables.SamplingIntervalDiagnosticsArrayNode;
import org.eclipse.milo.opcua.sdk.server.model.nodes.variables.ServerDiagnosticsSummaryNode;
import org.eclipse.milo.opcua.sdk.server.model.nodes.variables.SubscriptionDiagnosticsArrayNode;
import org.eclipse.milo.opcua.sdk.server.model.types.objects.ServerDiagnosticsType;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.QualifiedName;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UByte;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.structured.SamplingIntervalDiagnosticsDataType;
import org.eclipse.milo.opcua.stack.core.types.structured.ServerDiagnosticsSummaryDataType;
import org.eclipse.milo.opcua.stack.core.types.structured.SubscriptionDiagnosticsDataType;

@org.eclipse.milo.opcua.sdk.core.annotations.UaObjectNode(typeName = "0:ServerDiagnosticsType")
public class ServerDiagnosticsNode extends BaseObjectNode implements ServerDiagnosticsType {

    public ServerDiagnosticsNode(
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
    public Boolean getEnabledFlag() {
        Optional<Boolean> property = getProperty(ServerDiagnosticsType.ENABLED_FLAG);

        return property.orElse(null);
    }

    @Override
    public PropertyNode getEnabledFlagNode() {
        Optional<VariableNode> propertyNode = getPropertyNode(ServerDiagnosticsType.ENABLED_FLAG.getBrowseName());

        return propertyNode.map(n -> (PropertyNode) n).orElse(null);
    }

    @Override
    public void setEnabledFlag(Boolean value) {
        setProperty(ServerDiagnosticsType.ENABLED_FLAG, value);
    }

    @Override
    public SessionsDiagnosticsSummaryNode getSessionsDiagnosticsSummaryNode() {
        Optional<ObjectNode> component = getObjectComponent("SessionsDiagnosticsSummary");

        return component.map(node -> (SessionsDiagnosticsSummaryNode) node).orElse(null);
    }

    @Override
    public ServerDiagnosticsSummaryDataType getServerDiagnosticsSummary() {
        Optional<VariableNode> component = getVariableComponent("ServerDiagnosticsSummary");

        return component.map(node -> (ServerDiagnosticsSummaryDataType) node.getValue().getValue().getValue()).orElse(null);
    }

    @Override
    public ServerDiagnosticsSummaryNode getServerDiagnosticsSummaryNode() {
        Optional<VariableNode> component = getVariableComponent("ServerDiagnosticsSummary");

        return component.map(node -> (ServerDiagnosticsSummaryNode) node).orElse(null);
    }

    @Override
    public void setServerDiagnosticsSummary(ServerDiagnosticsSummaryDataType value) {
        getVariableComponent("ServerDiagnosticsSummary")
            .ifPresent(n -> n.setValue(new DataValue(new Variant(value))));
    }

    @Override
    public SamplingIntervalDiagnosticsDataType[] getSamplingIntervalDiagnosticsArray() {
        Optional<VariableNode> component = getVariableComponent("SamplingIntervalDiagnosticsArray");

        return component.map(node -> (SamplingIntervalDiagnosticsDataType[]) node.getValue().getValue().getValue()).orElse(null);
    }

    @Override
    public SamplingIntervalDiagnosticsArrayNode getSamplingIntervalDiagnosticsArrayNode() {
        Optional<VariableNode> component = getVariableComponent("SamplingIntervalDiagnosticsArray");

        return component.map(node -> (SamplingIntervalDiagnosticsArrayNode) node).orElse(null);
    }

    @Override
    public void setSamplingIntervalDiagnosticsArray(SamplingIntervalDiagnosticsDataType[] value) {
        getVariableComponent("SamplingIntervalDiagnosticsArray")
            .ifPresent(n -> n.setValue(new DataValue(new Variant(value))));
    }

    @Override
    public SubscriptionDiagnosticsDataType[] getSubscriptionDiagnosticsArray() {
        Optional<VariableNode> component = getVariableComponent("SubscriptionDiagnosticsArray");

        return component.map(node -> (SubscriptionDiagnosticsDataType[]) node.getValue().getValue().getValue()).orElse(null);
    }

    @Override
    public SubscriptionDiagnosticsArrayNode getSubscriptionDiagnosticsArrayNode() {
        Optional<VariableNode> component = getVariableComponent("SubscriptionDiagnosticsArray");

        return component.map(node -> (SubscriptionDiagnosticsArrayNode) node).orElse(null);
    }

    @Override
    public void setSubscriptionDiagnosticsArray(SubscriptionDiagnosticsDataType[] value) {
        getVariableComponent("SubscriptionDiagnosticsArray")
            .ifPresent(n -> n.setValue(new DataValue(new Variant(value))));
    }

}
