<%@ include file="/init.jsp" %>

<div>sample-two-portlet Portlet - someRenderedParameter: ${someValue}</div>

<c:if test="${not empty statusResourceUrl}">
    <div>Resource URL: <a href="${statusResourceUrl}">Resource link for task ${backgroundTaskId}</a>
    </div>
    <div id="<portlet:namespace/>poll-task">Processing</div>
</c:if>

<aui:form action="${startTaskActionUrl}" method="post">
    <aui:button name="submit" type="submit"/>
</aui:form>

<c:if test="${not empty statusResourceUrl}">
<script>
  (function poll() {
    let completion = 0;
    $.ajax({
      url: "${statusResourceUrl}",
      method: 'get',
      success: function (data) {
        let newText = "Background task ${backgroundTaskId} complete: " + (data < 0? "Failed" : (data + "%"));
        $("#<portlet:namespace/>poll-task").text(newText);
        completion = data;
      },
      error: function () {
      },
      complete: function () {
        if (completion < 100 && completion >= 0) {
          setTimeout(poll, 1000);
        }
      }
    });
  })();
</script>
</c:if>