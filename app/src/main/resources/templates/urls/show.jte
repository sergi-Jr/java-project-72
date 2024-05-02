@import hexlet.code.core.dto.UrlPage
@import hexlet.code.core.utils.NamedRoutes
@import java.time.format.DateTimeFormatter
@import java.util.Date

@param UrlPage page
@param DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")

@template.layout.page(
page = page,
content = @`
    <div>
        <h1 class="display-4">Сайт: ${page.getName()}</h1>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Имя</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">${page.getId()}</th>
                <td>${page.getName()}</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div>
        <h2 class="display-6">Проверки</h2>
        <div>
            <form action="${NamedRoutes.urlCheckPath(page.getId())}" method="post">
                <div>
                    <input type="text" name="url" value="${page.getName()}" hidden="hidden">
                </div>
                <div class="col-auto">
                    <button type="submit" class="btn btn-primary">Начать проверку</button>
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
                    <th scope="col">${formatter.format(check.getCreatedAt().toLocalDateTime())}</th>
                </tr>
            @endfor
            </tbody>
        </table>
    </div>
`
)