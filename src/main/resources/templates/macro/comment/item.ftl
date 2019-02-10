<#macro comment_item comment="${comment}">
    <li id="${comment.commentUuid}">
        <div>
            ${comment.description}
        </div>
    </li>
</#macro>