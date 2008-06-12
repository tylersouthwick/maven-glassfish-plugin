/*******************************************************************************
 *
 * Copyright (c) 2007, Dave Whitla
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 *  * Neither the name of the copyright holder nor the names of contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 * OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 ******************************************************************************/

package org.glassfish.maven.plugin.command;

import org.glassfish.maven.plugin.GlassfishMojo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dwhitla at Apr 9, 2007 7:03:10 PM
 *
 * @author <a href="mailto:dave.whitla@ocean.net.au">Dave Whitla</a>
 * @version $Id: ListDomainsCommand.java 0 Apr 9, 2007 7:03:10 PM dwhitla $
 */
public class ListDomainsCommand extends AsadminCommand {
    private File domainDirectory;

    public ListDomainsCommand(GlassfishMojo sharedContext) {
        super(sharedContext);
        this.domainDirectory = sharedContext.getDomainDirectory();
    }

    protected String getName() {
        return "list-domains";
    }

    protected List<String> getParameters() {
        List<String> parameters = new ArrayList<String>();
        addOptionalParameter(parameters, "--domaindir", domainDirectory);
        return parameters;
    }

    protected String getErrorMessage() {
        return "Unable to list domains in directory \"" + domainDirectory.getAbsolutePath() + "\".";
    }
    
}
