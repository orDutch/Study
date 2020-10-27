
package my.experiments.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the my.experiments.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Kitty_QNAME = new QName("http://services.experiments.my/", "Kitty");
    private final static QName _Feed_QNAME = new QName("http://services.experiments.my/", "feed");
    private final static QName _FeedResponse_QNAME = new QName("http://services.experiments.my/", "feedResponse");
    private final static QName _Feel_QNAME = new QName("http://services.experiments.my/", "feel");
    private final static QName _FeelResponse_QNAME = new QName("http://services.experiments.my/", "feelResponse");
    private final static QName _GiveDrink_QNAME = new QName("http://services.experiments.my/", "give_drink");
    private final static QName _GiveDrinkResponse_QNAME = new QName("http://services.experiments.my/", "give_drinkResponse");
    private final static QName _Play_QNAME = new QName("http://services.experiments.my/", "play");
    private final static QName _PlayResponse_QNAME = new QName("http://services.experiments.my/", "playResponse");
    private final static QName _SayHello_QNAME = new QName("http://services.experiments.my/", "sayHello");
    private final static QName _SayHelloResponse_QNAME = new QName("http://services.experiments.my/", "sayHelloResponse");
    private final static QName _Treat_QNAME = new QName("http://services.experiments.my/", "treat");
    private final static QName _TreatResponse_QNAME = new QName("http://services.experiments.my/", "treatResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: my.experiments.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LiveMetrics }
     * 
     */
    public LiveMetrics createLiveMetrics() {
        return new LiveMetrics();
    }

    /**
     * Create an instance of {@link Feed }
     * 
     */
    public Feed createFeed() {
        return new Feed();
    }

    /**
     * Create an instance of {@link FeedResponse }
     * 
     */
    public FeedResponse createFeedResponse() {
        return new FeedResponse();
    }

    /**
     * Create an instance of {@link Feel }
     * 
     */
    public Feel createFeel() {
        return new Feel();
    }

    /**
     * Create an instance of {@link FeelResponse }
     * 
     */
    public FeelResponse createFeelResponse() {
        return new FeelResponse();
    }

    /**
     * Create an instance of {@link GiveDrink }
     * 
     */
    public GiveDrink createGiveDrink() {
        return new GiveDrink();
    }

    /**
     * Create an instance of {@link GiveDrinkResponse }
     * 
     */
    public GiveDrinkResponse createGiveDrinkResponse() {
        return new GiveDrinkResponse();
    }

    /**
     * Create an instance of {@link Play }
     * 
     */
    public Play createPlay() {
        return new Play();
    }

    /**
     * Create an instance of {@link PlayResponse }
     * 
     */
    public PlayResponse createPlayResponse() {
        return new PlayResponse();
    }

    /**
     * Create an instance of {@link SayHello }
     * 
     */
    public SayHello createSayHello() {
        return new SayHello();
    }

    /**
     * Create an instance of {@link SayHelloResponse }
     * 
     */
    public SayHelloResponse createSayHelloResponse() {
        return new SayHelloResponse();
    }

    /**
     * Create an instance of {@link Treat }
     * 
     */
    public Treat createTreat() {
        return new Treat();
    }

    /**
     * Create an instance of {@link TreatResponse }
     * 
     */
    public TreatResponse createTreatResponse() {
        return new TreatResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LiveMetrics }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LiveMetrics }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.experiments.my/", name = "Kitty")
    public JAXBElement<LiveMetrics> createKitty(LiveMetrics value) {
        return new JAXBElement<LiveMetrics>(_Kitty_QNAME, LiveMetrics.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Feed }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Feed }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.experiments.my/", name = "feed")
    public JAXBElement<Feed> createFeed(Feed value) {
        return new JAXBElement<Feed>(_Feed_QNAME, Feed.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeedResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FeedResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.experiments.my/", name = "feedResponse")
    public JAXBElement<FeedResponse> createFeedResponse(FeedResponse value) {
        return new JAXBElement<FeedResponse>(_FeedResponse_QNAME, FeedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Feel }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Feel }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.experiments.my/", name = "feel")
    public JAXBElement<Feel> createFeel(Feel value) {
        return new JAXBElement<Feel>(_Feel_QNAME, Feel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeelResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FeelResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.experiments.my/", name = "feelResponse")
    public JAXBElement<FeelResponse> createFeelResponse(FeelResponse value) {
        return new JAXBElement<FeelResponse>(_FeelResponse_QNAME, FeelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GiveDrink }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GiveDrink }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.experiments.my/", name = "give_drink")
    public JAXBElement<GiveDrink> createGiveDrink(GiveDrink value) {
        return new JAXBElement<GiveDrink>(_GiveDrink_QNAME, GiveDrink.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GiveDrinkResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GiveDrinkResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.experiments.my/", name = "give_drinkResponse")
    public JAXBElement<GiveDrinkResponse> createGiveDrinkResponse(GiveDrinkResponse value) {
        return new JAXBElement<GiveDrinkResponse>(_GiveDrinkResponse_QNAME, GiveDrinkResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Play }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Play }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.experiments.my/", name = "play")
    public JAXBElement<Play> createPlay(Play value) {
        return new JAXBElement<Play>(_Play_QNAME, Play.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlayResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PlayResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.experiments.my/", name = "playResponse")
    public JAXBElement<PlayResponse> createPlayResponse(PlayResponse value) {
        return new JAXBElement<PlayResponse>(_PlayResponse_QNAME, PlayResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHello }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SayHello }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.experiments.my/", name = "sayHello")
    public JAXBElement<SayHello> createSayHello(SayHello value) {
        return new JAXBElement<SayHello>(_SayHello_QNAME, SayHello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SayHelloResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.experiments.my/", name = "sayHelloResponse")
    public JAXBElement<SayHelloResponse> createSayHelloResponse(SayHelloResponse value) {
        return new JAXBElement<SayHelloResponse>(_SayHelloResponse_QNAME, SayHelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Treat }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Treat }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.experiments.my/", name = "treat")
    public JAXBElement<Treat> createTreat(Treat value) {
        return new JAXBElement<Treat>(_Treat_QNAME, Treat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TreatResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TreatResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.experiments.my/", name = "treatResponse")
    public JAXBElement<TreatResponse> createTreatResponse(TreatResponse value) {
        return new JAXBElement<TreatResponse>(_TreatResponse_QNAME, TreatResponse.class, null, value);
    }

}
