@import hexlet.code.core.dto.UrlPage
@import hexlet.code.core.utils.NamedRoutes
@import java.util.Date

@param UrlPage page

@template.layout.page(
page = page,
content = @`
    <div>
        <form action="${NamedRoutes.urlCheckPath(page.getId())}" method="post">
            <div>
                <input type="text" name="url" value="${page.getName()}" hidden="hidden">
            </div>
            <div class="col-auto">
                <button type="submit" class="btn btn-primary">Inspect</button>
            </div>
        </form>
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Код ответа</th>
            <th scope="col">Title</th>
            <th scope="col">H1</th>
            <th scope="col">Description</th>
            <th scope="col">Дата проверки</th>
        </tr>
        </thead>
        <tbody>
        @for(var check : page.getChecks())
            <tr>
                <th scope="col">${check.getId()}</th>
                <th scope="col">${check.getStatusCode()}</th>
                <th scope="col">${check.getTitle()}</th>
                <th scope="col">${check.getH1()}</th>
                <th scope="col">${check.getDescription()}</th>
                <th scope="col">${new Date(check.getCreatedAt().getTime()).toString()}</th>
            </tr>
        @endfor
        </tbody>
    </table>
`
)