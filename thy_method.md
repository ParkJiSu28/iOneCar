# 개발 방법 및  Thymeleaf Post, get Method 

## 1. 기초 정리 

- **컨트롤러(Controller)** : 웹 요청을 받아 처리하는 Java 클래스  
- **템플릿(Thymeleaf)** : `src/main/resources/templates/app` 아래 HTML 파일에서 `${변수}` 형태로 데이터 출력  
- **DTO, Service, DB Mapper**
 - DTO + Service + Mapper(Repository) 구조로 MVC 분리
- @ModelAttribute를 활용해 DTO 바인딩

---
Thymeleaf에서 th:object/th:field로 폼 데이터 자동 매핑

 DB 접근은 Mapper(MyBatis/JPA 등)에서 담당

GET : @GetMapping · 템플릿에서 th:each, th:text 써서 데이터 출력

POST : <form method="post"> · 컨트롤러에서 데이터 저장, 끝나면 redirect

UPDATE : 기존 데이터 양식(th:value, th:text) · 제출은 POST

|기능       |예시 코드|
|----------|---------------------------------------------------|
|값 출력	|<span th:text="${변수}"></span>|
|값 입력	|<input th:value="${변수}">|
|링크|	<a th:href="@{/경로}">텍스트</a>|
|URL 조립|	`<a th:href="@{|
|반복 출력|	<tr th:each="item : ${리스트}">...</tr>|
---

## 2. BoardDto  
```java

// dto/BoardDto.java
public class BoardDto {
    private Long id;
    private String title;
    private String content;

}
```
---

## 3. Mapper   

```java
// mapper/BoardMapper.java
@Mapper
public interface BoardMapper {
    List<BoardDto> findAll();
    BoardDto findById(Long id);
    void insert(BoardDto board);
    void update(BoardDto board);
}
```

**resources/mapper/BoardMapper.xml**

```html

<mapper namespace="com.example.demo.mapper.BoardMapper"> 
    <select id="findAll" resultType="com.example.demo.dto.BoardDto"> 
        SELECT * FROM board </select> 
    <select id="findById" parameterType="long" resultType="com.example.demo.dto.BoardDto"> 
        SELECT * FROM board WHERE id = #{id} </select> 
    <insert id="insert" parameterType="com.example.demo.dto.BoardDto" useGeneratedKeys="true" keyProperty="id"> 
        INSERT INTO board(title, content) VALUES(#{title}, #{content}) </insert> 
    <update id="update" parameterType="com.example.demo.dto.BoardDto"> 
        UPDATE board SET title=#{title}, content=#{content} WHERE id=#{id} </update> 
</mapper>

```


## 4. Service

```java
// service/BoardService.java
public interface BoardService {
    List<BoardDto> getBoardList();
    BoardDto getBoard(Long id);
    void createBoard(BoardDto dto);
    void updateBoard(BoardDto dto);
}

// service/BoardServiceImpl.java
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    @Override
    public List<BoardDto> getBoardList() {
        return boardMapper.findAll();
    }
    @Override
    public BoardDto getBoard(Long id) {
        return boardMapper.findById(id);
    }
    @Override
    public void createBoard(BoardDto dto) {
        boardMapper.insert(dto);
    }
    @Override
    public void updateBoard(BoardDto dto) {
        boardMapper.update(dto);
    }
}
```
## 5. Controller

```java
// controller/BoardController.java
@Controller
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;

    // 목록
    @GetMapping
    public String list(Model model) {
        model.addAttribute("boards", boardService.getBoardList());
        return "board/list";
    }
    // 상세
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.getBoard(id));
        return "board/detail";
    }
    // 등록 폼
    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("boardDto", new BoardDto());
        return "board/new";
    }
    // 등록 처리
    @PostMapping
    public String save(@ModelAttribute BoardDto boardDto) {
        boardService.createBoard(boardDto);
        return "redirect:/boards";
    }
    // 수정 폼
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("boardDto", boardService.getBoard(id));
        return "board/edit";
    }
    // 수정 처리
    @PostMapping("/{id}/edit")
    public String edit(@ModelAttribute BoardDto boardDto) {
        boardService.updateBoard(boardDto);
        return "redirect:/boards/" + boardDto.getId();
    }
}
```


## 6.Thymeleaf 예시 템플릿

###목록 (templates/board/list.html)
```html

<table>
  <tr><th>ID</th><th>제목</th></tr>
  <tr th:each="board : ${boards}">
    <td th:text="${board.id}"></td>
    <td>
      <a th:href="@{|/boards/${board.id}|}" th:text="${board.title}"></a>
    </td>
  </tr>
</table>
<a href="/boards/new">글쓰기</a>
```


###등록/수정 폼 (templates/board/new.html, edit.html)

```html
<form th:action="@{/boards}" method="post" th:object="${boardDto}">
  <div>
    제목: <input type="text" th:field="*{title}" />
  </div>
  <div>
    내용: <textarea th:field="*{content}"></textarea>
  </div>
  <button type="submit" th:text="${#strings.contains(#httpServletRequest.requestURI, 'edit') ? '수정' : '저장'}"></button>
</form>

```