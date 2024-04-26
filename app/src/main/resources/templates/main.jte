@import hexlet.code.core.utils.NamedRoutes
@import hexlet.code.core.dto.BuildUrlPage

@param BuildUrlPage page

@template.layout.page(
page = page,
content = @`
    <form action="${NamedRoutes.urlsPath()}" method="post">
        <div class="form-row">
            <div class="col">
                <label>Type some url below
                    <input type="url" class="form-control" required name="url" value="${page.getName()}" pattern="https?://(www\.)?\S+\.\S+">
                </label>
                <small class="form-text text-muted">Only http[s]://example.com[:port] is allowed</small>
            </div>
            <div class="col-auto">
                <button type="submit" class="btn btn-primary">Inspect</button>
            </div>
        </div>
    </form>
`
)