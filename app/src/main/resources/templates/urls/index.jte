@import hexlet.code.dto.UrlsPage
@import hexlet.code.utils.NamedRoutes
@import java.time.format.DateTimeFormatter


@param UrlsPage page
@param DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")

@template.layout.page(
page = page,
content = @`
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">URL</th>
            <th scope="col">Последний результат</th>
            <th scope="col">Код ответа</th>
        </tr>
        </thead>
        <tbody>
        @for(var p : page.getUrls())
            <tr>
                <td>${p.getId()}</td>
                <td><a href="${NamedRoutes.urlPath(p.getId())}">${p.getName()}</a></td>
                @if (page.getLatestChecks().get(p.getId()) != null)
                    <td>
                        ${formatter.format(page.getLatestChecks().get(p.getId()).getCreatedAt().toLocalDateTime())}
                    </td>
                    <td>${page.getLatestChecks().get(p.getId()).getStatusCode()}</td>
                @else
                    <td></td>
                    <td></td>
                @endif
            </tr>
        @endfor
        </tbody>
    </table>
`
)