<#macro issue_item issue="${issue}">
    <li id="${issue.issueUuid}">
    <div class="collapsible-header">
        <i class="material-icons visibility-icon">visibility</i>

        <span>${issue.title}</span>

        <#switch issue.status>
            <#case 1><span class="new badge blue" data-badge-caption="New"></span><#break>
            <#case 2><span class="new badge orange" data-badge-caption="In progress"></span><#break>
            <#case 3><span class="new badge green" data-badge-caption="Done"></span><#break>
            <#case 4><span class="new badge red" data-badge-caption="Cancel"></span><#break>
        </#switch>
    </div>

    <div class="collapsible-body">
        <div class="row">
            <div class="col s12">
                <div class="hide-on-small-and-down right"">
                    <a class="delete-button waves-effect waves-light red darken-2 center-align btn modal-trigger"
                       href="#delete-modal" data-uuid="${issue.issueUuid}">
                        <i class="fas fa-trash left"></i> delete</a>
                    <a class="edit-button waves-effect waves-light yellow darken-2 center-align btn"
                       href="${WebPath.getISSUE()}?uuid=${issue.issueUuid}">
                        <i class="fas fa-pen left"></i> edit</a>
                </div>

                <div class="hide-on-med-and-up">
                    <a class="dropdown-trigger center-align btn blue darken-2 col s12" href="#!" data-target="action-issue-dropdown-${issue.issueUuid}">
                        <i class="fas fa-angle-double-down"></i> Action</a>
                    <ul id="action-issue-dropdown-${issue.issueUuid}" class="dropdown-content">
                        <li><a class="edit-button black-text" href="${WebPath.getISSUE()}?uuid=${issue.issueUuid}">
                                <i class="fas fa-pen left"></i> edit</a></li>
                        <li class="divider"></li>
                        <li><a class="delete-button black-text modal-trigger" href="#delete-modal" data-id="${issue.issueUuid}">
                                <i class="fas fa-trash left"></i> delete</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="input-field col m6 s12">
                <blockquote>
                    <p><i class="material-icons medium-icon">query_builder</i><b> Create: </b></p>
                    <p><i class="material-icons medium-icon">watch_later</i><b> Edit: </b></p>
                    <p><i class="material-icons medium-icon">watch_later</i><b> Deadline: </b></p>
                </blockquote>
            </div>

            <div class="input-field col m6 s12">
                <select>
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
            <p> ${issue.description}</p>
        </div>

        <div class="row">
            <p><b>Comments</b></p>
            <p> ${issue.description}</p>
        </div>

    </div>
    </li>

    <script>
        $(document).ready(function(){
            $('select').formSelect();
            $('.dropdown-trigger').dropdown();
            visibilityItems(false);
        });
    </script>
</#macro>