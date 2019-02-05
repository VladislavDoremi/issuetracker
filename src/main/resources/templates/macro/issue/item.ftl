<#macro issue_item issue="${issue}">
    <li id="${issue.id}">
    <div class="collapsible-header">
    <i class="material-icons">error</i>
    <span>${issue.title}</span>

    <#switch issue.status>
        <#case 0><span class="new badge blue accent-2" data-badge-caption="New"></span><#break>
        <#case 1><span class="new badge orange accent-2" data-badge-caption="In progress"></span><#break>
        <#case 2><span class="new badge green accent-2" data-badge-caption="Done"></span><#break>
    </#switch>

    </div>
    <div class="collapsible-body">
    <p class="right">
        <a id="delete-button-${issue.id}" class="waves-effect waves-light red darken-2 center-align btn-small modal-trigger" href="#delete-modal"><i class="material-icons left">delete</i>delete</a>
        <a id="edit-button-${issue.id}" class="waves-effect waves-light yellow darken-2 center-align btn-small"><i class="material-icons left">edit</i>edit</a>
    </p>
    <blockquote>
        <p><b>Author: </b>${issue.author}</p>
        <p><b>Create: </b>xxxx</p>
        <p><b>Edit: </b>xxxx</p>
    </blockquote>
    <br/>
    <p><b>Description</b></p>
    <p> ${issue.description}</p>
    </div>
    </li>
</#macro>