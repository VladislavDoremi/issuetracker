<#macro issue_item issue="${issue}">
    <li id="${issue.id}">
    <div class="collapsible-header">
        <i class="material-icons visibility-icon">visibility</i>

        <span>${issue.title}</span>

        <#switch issue.status>
            <#case 0><span class="new badge blue" data-badge-caption="New"></span><#break>
            <#case 1><span class="new badge orange" data-badge-caption="In progress"></span><#break>
            <#case 2><span class="new badge green" data-badge-caption="Done"></span><#break>
            <#case 3><span class="new badge red" data-badge-caption="Cancel"></span><#break>
        </#switch>
    </div>

    <div class="collapsible-body">
        <div class="row">
            <div class="col s12">
                <div class="hide-on-small-and-down right"">
                    <a id="delete-button-${issue.id}" class="waves-effect waves-light red darken-2 center-align btn modal-trigger
                       href="#delete-modal">
                        <i class="fas fa-trash left"></i> delete</a>
                    <a id="edit-button-${issue.id}" class="waves-effect waves-light yellow darken-2 center-align btn">
                        <i class="fas fa-pen left"></i> edit</a>
                </div>

                <div class="hide-on-med-and-up">
                    <a class="dropdown-trigger center-align btn blue darken-2 col s12" href="#!" data-target="action-issue-dropdown-${issue.id}">
                        <i class="fas fa-angle-double-down"></i> Action</a>

                    <ul id="action-issue-dropdown-${issue.id}" class="dropdown-content">

                        <li><a id="edit-button-${issue.id}" class="black-text">
                                <i class="fas fa-pen left"></i> edit</a></li>

                        <li class="divider"></li>

                        <li><a id="delete-button-${issue.id}" class="black-text modal-trigger" href="#delete-modal">
                                <i class="fas fa-trash left"></i> delete</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="input-field col m6 s12">
                <blockquote>
                    <p><i class="material-icons medium-icon">person</i><b> Author: </b>${issue.authorId}</p>
                    <p><i class="material-icons medium-icon">query_builder</i><b> Create: </b>01/01/2019</p>
                    <p><i class="material-icons medium-icon">watch_later</i><b> Edit: </b>01/01/2019</p>
                    <p><i class="material-icons medium-icon">watch_later</i><b> Deadline: </b>01/01/2019</p>
                </blockquote>
            </div>

            <div class="input-field col m6 s12">
                <select>
                    <option value="0" selected>New</option>
                    <option value="1">In progress</option>
                    <option value="2">Done</option>
                    <option value="3">Cancel</option>
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
            visibilityIcon(false);
            hideItems(true)
        });
    </script>
</#macro>