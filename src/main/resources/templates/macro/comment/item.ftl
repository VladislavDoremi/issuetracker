<#macro comment_item comment="${comment}">
    <li id="${comment.commentUuid}" class="collection-item">
        <div><b>${comment.createAt}</b></div>
        <div>${comment.description}</div>
    </li>
</#macro>