/*
 * Copyright 2008-2011 Red Hat, Inc, and individual contributors.
 * 
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 * 
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.projectodd.stilts.protocol.client;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.projectodd.stilts.protocol.StompFrame;
import org.projectodd.stilts.protocol.StompFrame.Command;
import org.projectodd.stilts.protocol.StompFrame.Header;

public class ClientReceiptHandler extends AbstractClientControlFrameHandler {

    public ClientReceiptHandler(ClientContext clientContext) {
        super( clientContext, Command.RECEIPT );
    }

    @Override
    public void handleControlFrame(ChannelHandlerContext channelContext, StompFrame frame) {
        String receiptId = frame.getHeader( Header.RECEIPT_ID );
        getClientContext().receiptReceived( receiptId );
    }

}
