<#import "../comment/form.ftl" as comment_form>

<#macro issue_item issue="${issue}">
    <li id="${issue.issueUuid}" data-issue-uuid="${issue.issueUuid}">
    <div class="collapsible-header">
        <i class="material-icons visibility-icon">visibility</i>

        <span>${issue.title}</span>

        <#switch issue.status>
            <#case 1><span id="status-badge-${issue.issueUuid}" class="new badge blue" data-badge-caption="New"></span><#break>
            <#case 2><span id="status-badge-${issue.issueUuid}" class="new badge orange" data-badge-caption="In progress"></span><#break>
            <#case 3><span id="status-badge-${issue.issueUuid}" class="new badge green" data-badge-caption="Done"></span><#break>
            <#case 4><span id="status-badge-${issue.issueUuid}" class="new badge red" data-badge-caption="Cancel"></span><#break>
        </#switch>

    </div>

    <div class="collapsible-body">
        <div class="row">
            <div class="col s12">
                <div class="hide-on-small-and-down right">
                    <a class="issue-delete-btn waves-effect waves-light red darken-2 center-align btn modal-trigger"
                       href="#issue-delete-modal" data-issue-uuid="${issue.issueUuid}">
                        <i class="fas fa-trash left"></i> delete</a>
                    <a class="issue-edit-btn waves-effect waves-light yellow darken-2 center-align btn"
                       href="${WebPath.getISSUE()}?issueUuid=${issue.issueUuid}">
                        <i class="fas fa-pen left"></i> edit</a>
                </div>

                <div class="hide-on-med-and-up">
                    <a class="dropdown-trigger center-align btn blue darken-2 col s12" href="#!" data-target="issue-${issue.issueUuid}-action-dropdown">
                        <i class="fas fa-angle-double-down"></i> Action</a>
                    <ul id="issue-${issue.issueUuid}-action-dropdown" class="dropdown-content">
                        <li><a class="issue-edit-btn black-text" href="${WebPath.getISSUE()}?issueUuid=${issue.issueUuid}">
                                <i class="fas fa-pen left"></i> edit</a></li>
                        <li class="divider"></li>
                        <li><a class="issue-delete-btn black-text modal-trigger" href="#issue-delete-modal" data-issue-uuid="${issue.issueUuid}">
                                <i class="fas fa-trash left"></i> delete</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="input-field col m6 s12">
                <blockquote>
                    <p><i class="material-icons medium-icon">watch_later</i><b> Start: </b>${issue.startDate}</p>
                    <p><i class="material-icons medium-icon">watch_later</i><b> Deadline: </b>${issue.deadlineDate}</p>
                </blockquote>
            </div>

            <div class="input-field col m6 s12">
                <select class="select-status" data-issue-uuid="${issue.issueUuid}">
                    <option value="1" <#if issue.status = 1>selected</#if>>New</option>
                    <option value="2" <#if issue.status = 2>selected</#if>>In progress</option>
                    <option value="3" <#if issue.status = 3>selected</#if>>Done</option>
                    <option value="4" <#if issue.status = 4>selected</#if>>Cancel</option>
                </select>
                <label>Status</label>
            </div>
        </div>

        <div class="row">
            <p><b>Description</b></p>
            <p>${issue.description}</p>
        </div>

        <div class="row">
            <a class="show-comment-btn waves-effect waves-light blue darken-2 center-align btn col s12"
                data-issue-uuid="${issue.issueUuid}">Show all comments</a>
        </div>

        <div id="comments-${issue.issueUuid}" class="row"></div>

        <@comment_form.comment_form issue=issue/>

    </div>
    </li>

</#macro>