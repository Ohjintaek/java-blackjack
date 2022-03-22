# 연료 주입

## 기능 정리

- [x] 예약 시 목적지의 대략적인 이동거리를 입력받는다.
- [x] 차량별로 주입해야할 연료량을 확인하는 보고서를 생성한다.

# java-blackjack

## 기능 정리

- [규칙 정리](https://namu.wiki/w/%EB%B8%94%EB%9E%99%EC%9E%AD(%EC%B9%B4%EB%93%9C%EA%B2%8C%EC%9E%84))
    - 블랙잭 : 처음 받은 2장의 카드가 A10, AJ, AQ, AK
    - hit : 플레이어가 카드를 한장 받아서 자신의 카드뭉치에 추가함
    - stay : 카드를 더이상 받지 않고 턴을 넘김
    - bust : 카드의 합이 21을 초과하여 카드를 더이상 받을 수 없는 상태
    - ACE는 1 또는 11로 계산한다.
    - 딜러는 16이하면 무조건 hit, 참여자는 bust가 아니라면 얼마든지 hit할 수 있다.
    - 승패 규칙
        - 플레이어 Bust / 딜러 Bust => 딜러 Win
        - 플레이어 Bust / 딜러 Not-Bust => 딜러 Win
        - 플레이어 Not-Bust / 딜러 Bust => 플레이어 Win
        - 플레이어 Not-Bust / 딜러 Not-Bust => 스코어 계산 (2장일때 A10, AJ, AQ, AK만 먼저 체크)
        - 점수가 같은 경우 => 무승부
    - 참여자가 블랙잭으로 이기면 배팅금액의 1.5배를 얻는다.

- [x] 참여할 사람의 이름을 입력
    - [x] 쉼표 기준으로 분리
    - [x] 사람 수는 1명 이상 8명 이하로 한다.
    - [x] 이름이 공백이면 안된다.("", " " 등)
    - [x] 중복된 이름은 안된다.
    - [x] 딜러는 이름으로 하면 안된다.
- [x] 모든 참여자의 배팅 금액을 입력 확인
    - [x] 배팅은 숫자로 입력해야한다.
    - [x] 배팅은 10원 단위로 배팅해야한다.
- [X] 딜러와 참여자에게 카드를 나눠줌
    - [x] 딜러는 2장을 받음
        - [x] 두번째로 받은 카드는 공개하지 않는다
    - [x] 참여자는 2장을 받음
    - [x] 나누어주는 카드가 중복되지 않는다
    - [x] 딜러와 참여자가 받은 카드를 출력
    - [x] 카드를 모두 분배한 경우 새로 채운다.
    - [x] 매 게임 새로운 52장 카드로 시작한다.
- [x] 카드의 총합을 계산하는 기능
    - [x] Ace는 1또는 11로 계산할 수 있고, King, Queen, Jack은 10으로 계산한다.
    - [x] Ace의 점수는 11로 계산했을 때 점수의 총합이 21을 초과하면 1로 계산한다.
- [X] 참여자들이 돌아가면서 원하는 만큼 카드를 받는 기능
    - [x] y 또는 n을 입력한다.
        - [x] y를 입력하면 랜덤으로 한장 추가(hit)하고 자신이 가진 카드를 출력
        - [X] n을 입력하면 다음 참여자가 진행(stay)
    - [x] 가진 카드의 점수가 21을 초과하면 다음 참여자가 진행(Bust)
    - [x] 대문자(Y,N)로 입력받아도 된다
    - [x] y, n외 입력이 들어오면 예외를 발생시킨다.
- [x] 모든 참여자가 카드를 다 받았으면 딜러가 카드를 받음
    - [x] 딜러가 가진 카드의 점수가 16이하면 무조건 1장의 카드를 받음(딜러는 16이하라 한장의 카드를 더 받았습니다.출력)
    - [x] 딜러가 가진 카드의 점수가 17이상이면 멈춤
- [x] 딜러와 모든 참여자의 카드와 결과를 출력
- [x] 최종 승패를 계산하고 결과를 출력하는 기능 구현
    - [x] 모든 참여자가 딜러의 점수를 기준으로 승/무/패 계산
        - 플레이어 Bust / 딜러 Bust => 딜러 Win
        - 플레이어 Bust / 딜러 Not-Bust => 딜러 Win
        - 플레이어 Not-Bust / 딜러 Bust => 플레이어 Win
        - 플레이어 Not-Bust / 딜러 Not-Bust => 스코어 계산 (2장일때 A10, AJ, AQ, AK만 먼저 체크)
    - [x] 모든 참여자의 승/무/패에 따른 최종 수익 계산
        - [x] 참여자 승 : 배팅금액 만큼 추가로 얻는다.
            - [x] 참여자가 블랙잭으로 이기면 배팅금액의 1.5배를 얻는다.
        - [x] 참여자 무 : 배팅금액을 돌려받는다.
        - [x] 참여자 패 : 배팅금액을 잃는다.
    - [x] 딜러와 참여자의 최종 수익 출력

## State(상태) 관계 정리

- State
    - Ready
        - Running
            - Hit
                - DealerHit
                - ParticipantHit
        - Finished
            - Bust
                - DealerBust
                - ParticipantBust
            - Blackjack
                - DealerBlackjack
                - ParticipantBlackjack
            - Stay

---

# 1단계 리뷰 & 수정사항 정리

- [x] 도메인 패키지를 정리하자
    - 코드를 읽는데 많은 도움이 되고, 내가 생각한 도메인 구조를 이해하는데도 많은 도움이 된다.
    - 카드와 관련된 패키지(`card`), 플레이어와 관련된 패키지(`player`)로 분리했다.
- [x] 컨벤션을 잘 지켰는지 전체적으로 다시 확인해보자
    - [x] `isBLACKJACK()`을 `isBlackjack()`으로 수정했다.
- [x] 이름이 의도를 잘 나타내는지 다시 확인해보자(클래스, 메서드, 변수 등). 명시적으로 변경해볼 수 있으면 해보자.
    - [x] `FixDeck`을 확인하려면 그 안에 들어가서 값을 확인해야할 것 같다.
        - `FixDeck`는 10 스페이드만을 리턴하는 클래스였다. 그래서 이름을 `JustTenSpadeDeck`으로 수정했다.
    - [x] 클래스 이름만 보면 `Gamer`, `Player`, `Dealer`의 관계가 혼란스러울 것 같다.
        - 인터페이스 : `Gamer` -> `Player`
        - 추상 클래스 : `AbstractGamer` -> `AbstractPlayer`
        - 구현 클래스 : `Dealer` -> `Dealer`, `Player` -> `Participant`
        - Players에 Dealer도 포함하도록 수정
        - `AbstractPlayer`을 abstract 클래스로 수정하였다.
        - `isDealer()`와 `isValidRange()`를 추상 메서드가 되어야 할 것 같다.
    - [x] 승패 결과를 View로 보내는 Results
        - 딜러와 참여자의 결과를 나눠서 보냈음 -> 딜러와 참여자의 결과를 함께 보내도록 수정
    - [x] Cards라는 이름만 보면 단순하게 Card만을 모아둔 것인지 플레이어의 손에 들려있는 카드뭉치인지 알기 어려울 것 같다.
        - 조금 더 명확하게 플레이어가 가지고 있는 카드뭉치라는 것을 알려주기 위해 `Cards`를 `PlayerCards`로 이름을 수정했다.
        - `RandomDeck`에서도 `List<Card>`를 사용하는데 이부분도 일급컬렉션으로 포장할까 생각해봤는데 일급 컬렉션으로 묶어도 어떤 로직을 가지지않을 것 같아서 하지않았다.
- [x] 블랙잭의 판단 로직이 이런 방식이어야만 할까?
    - 블랙잭의 규칙을 잘못이해해서 로직이 복잡해졌던 것 같다. 규칙을 잘 이해하고 다시 수정했다.
- [x] `Players`생성자에 null이 파라미터로 오면 어떻게 되나?
    - Players를 생성할 때 null과 빈(Empty) 경우 검증하는 과정을 추가했다.
- [x] 입력이 잘못된 경우 게임이 다시 진행되려면 어떻게 해야할까?
    - 입력이 잘못된 경우는 플레이어의 이름을 입력받을때와 카드를 받을 때 y,n을 입력받을 때이다.
    - 잘못 입력한 경우 블랙잭 게임을 전부 다시 시작하는 것과 그 위치부터 다시 입력받는 것 중 고민해봤다.
    - 잘못 입력한 경우 그 위치부터 다시 입력받는 방식으로 구현했다.
    - 이름이 잘못된 경우 `IllegalArgumentException`인 경우만 재입력을 받는다.
    - 카드를 받을 때는 y, Y, n, N을 제외한 모든 입력일 때 재입력 받는다.
- [x] Card를 매번 재생성 할 필요가 있을까?
    - 이번 미션에서는 게임을 단 한번 하기 때문에 어차피 한번만 만들어질 것이라고 생각해서 캐싱하지 않았다.
    - 하지만 게임이 여러번 실행된다고 생각하면 캐싱을 해서 카드를 재사용하는것도 좋을 것 같다.
- [x] 게이머 추상 클래스에서 상수를 public이 아닌 상태로 구현할 수 없을까?
- [x] 인터페이스에서 구현체에 따라 값이 바뀌어야하는 메서드를 좀 더 명시적으로 바꿔보면 어떨까?
    - Gamer 인터페이스에서 `compareWinning`이라는 이름으로 int를 사용하고 있는데 상속받는 구현체에 따라 내용이 바뀌어야하는 점이 혼란스러울 수 있을 것 같다.
    - 판단 주체를 좀 더 명시적으로 변경해보면 어떨까요?
    - 승패를 판단하는 로직을 Outcome의 `match()`에서 하도록 수정했다.
- [x] 구현 클래스에 `equals`, `hashCode`, `toString`는 어떤 의미로 추가가된 것일까요?
    - `Dealer`와 `Participant`의 `equals`, `hashCode`, `toString`는 단순하게 `super`로 상위 `AbstractPlayer`의 메서드를 사용한다.
    - 그래서 없어도 되는 메서드인 것 같다. 습관적으로 만들어서 재정의한 것 같다.
    - equals에서 클래스를 비교하는 코드가 기존에는 `if (!(o instanceof AbstractPlayer))`로 되어있어서 `Dealer`와 `Participant`가 달라도 데이터가 같다면
      equals가 참이 나왔다.
    - `if (!(o instanceof AbstractPlayer))`를 `if (o == null || getClass() != o.getClass())`로 바꾸면서 구현 클래스가 다르다면 데이터가 같아도
      equals가 거짓이 나오도록 수정했다.
    - toString()은 구현 클래스마다 다를 수 있다고 생각되어서 구현 클래스에서 재정의했다.
- [x] 52장의 카드가 있는 `RandomDeck`의 List<Card>는 왜 static일까요?
    - static을 제거하도록 수정
    - 처음 RandomDeck의 코드를 작성할 때는 pick함수를 static으로 작성하면서 `List<Card>`도 static으로 작성했다.
    - 이후 수정하면서 신경 쓰지 못한 것 같다.
- 추상 클래스와 구현 클래스가 있을 때 모든 메서드를 테스트해야할까? 추상 클래스에서 테스트하고 구현 클래스는 `@Override`한 메서드만 테스트해도될까?
    - `AbstractPlayer`로 뽑은 이유가 뭘까요? 그 이유를 고민해보면 어떤 부분을 테스트해야할지 감이 좀 잡힐 것 같아요! :)
    - `AbstractPlayer`로 뽑은 이유는 딜러와 게임 참여자 객체의 중복되는 코드를 방지하기 위함이었다.
    - 구현 클래스(`Dealer`, `Participant`)에서 공통되는 부분은 추상 클래스에서 정의가 되어있다. 그러면 결국 구현 클래스에서 재정의하지 않은 메서드의 테스트는 `AbstractPlayer`의
      테스트와 같은 동작을 할 것이다.
    - 그래서 재정의를 하지 않는다면 꼭 할 필요는 없다고 생각된다! 테스트가 의미없이 중복되면 `AbstractPlayer`에서 기능이 변경되면 `AbstractPlayer`, `Dealer`
      , `Participant`의 테스트를 모두 고쳐야할 것인데 이런 것들도 결국 테스트 코드 중복 때문인 것 같다.
- 딜러는 일단 카드를 다 뽑아 놓는 방식으로 구현하셨군요?
    - 딜러는 16이하인 경우 무조건 카드를 받는다고 했기 때문에 `dealer.isValidRange()`함수로 16이하인 경우 계속 받도록 했다.
    - 예를들어 모든 플레이어가 bust가 되면 더이상 hit할 필요없이 딜러의 승리가 되지만 그런 경우에도 16을 초과할 때까지 hit한다.
    - 어차피 승패 판별을 할 때 플레이어가 bust면 무조건 딜러가 승리하기 때문에 상관없다고 생각했다.

# 2단계 리뷰 & 수정사항 정리

- [x] Card를 캐시한 부분을 간단하게 변경할 수 없을까?
    - 카드 번호와 모양의 name()를 이용해서 키를 만들어 더 간단하게 캐싱했다.
- [x] 내가 생각하는 중요한 도메인만이라도 커버리지 100%를 채워보면 어떤가?
    - 도메인에 대한 테스트 커버리지를 가능하면 100%로 채워봤다.
    - 커버리지라는 것을 처음 알았는데 어느 메서드에 대한 테스트를 하고있고 하지 않는지를 한눈에 볼 수 있어서 신기했다.
    - 대부분 테스트를 하고있다고 생각했지만 의외로 하지 않은 테스트가 많아서 커버리지를 잘 활용해야겠다고 생각했다.
    - 하지 못한 테스트
        - view, controller, main
- [x] 컨트롤러에서 Player가 hit하는 부분을 더 간결하게 변경할 수 없을까?
- [x] AbstractPlayer가 Player를 구현하고 있는데 implements Player를 적은 이유가 무엇일까?
    - 다른 크루의 코드와 HashMap 등을 보다보니 추상클래스와 인터페이스를 모두 extends, implements가 있어서 적용해봤다.
    - 이유는 생각해보지 않았는데 그 크루에게 물어보니 해도 되겠지만 하지않아도 된다는 말을 듣고 제거했다.
- [x] CardNumber, Suit의 symbol이 view에 종속되어있는게 아닌가?
    - CardNumber, Suit가 가진 정보 중 view에서 사용하는 것을 제거하고 view에 매핑용 enum을 만들었다.