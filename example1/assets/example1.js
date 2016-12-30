if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'example1'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'example1'.");
}
var example1 = function (_, Kotlin) {
  'use strict';
  var lazy = Kotlin.kotlin.lazy_un3fny$;
  var properties_0 = Kotlin.kotlin.properties;
  var get_js = Kotlin.kotlin.js.get_js_t5ir34$;
  Sprite.prototype = Object.create(Phaser.Sprite.prototype);
  Sprite.prototype.constructor = Sprite;
  Panda.prototype = Object.create(Sprite.prototype);
  Panda.prototype.constructor = Panda;
  MainState.prototype = Object.create(Phaser.State.prototype);
  MainState.prototype.constructor = MainState;
  OtherState.prototype = Object.create(Phaser.State.prototype);
  OtherState.prototype.constructor = OtherState;
  function main(args) {
    var game = initKoala(GameConfig(void 0, gameProperties_getInstance().screenWidth, gameProperties_getInstance().screenHeight, void 0, 'gameDiv', void 0, void 0, void 0, void 0, void 0, void 0, new MainState()));
  }
  function gameProperties() {
    gameProperties_instance = this;
    this.screenWidth = 640.0;
    this.screenHeight = 480.0;
  }
  gameProperties.$metadata$ = {
    type: Kotlin.TYPE.OBJECT,
    classIndex: Kotlin.newClassIndex(),
    simpleName: 'gameProperties',
    baseClasses: []
  };
  var gameProperties_instance = null;
  function gameProperties_getInstance() {
    if (gameProperties_instance === null) {
      gameProperties_instance = new gameProperties();
    }
    return gameProperties_instance;
  }
  function Assets() {
    Assets_instance = this;
    this.panda = new Asset('panda', 'assets/panda.png');
  }
  Assets.$metadata$ = {
    type: Kotlin.TYPE.OBJECT,
    classIndex: Kotlin.newClassIndex(),
    simpleName: 'Assets',
    baseClasses: []
  };
  var Assets_instance = null;
  function Assets_getInstance() {
    if (Assets_instance === null) {
      Assets_instance = new Assets();
    }
    return Assets_instance;
  }
  function Panda(x, y) {
    Sprite.call(this, x, y, Assets_getInstance().panda);
    this.anchor.set(0.5, 0.5);
  }
  Panda.prototype.update = function () {
    this.angle = this.angle + 5;
  };
  Panda.$metadata$ = {
    type: Kotlin.TYPE.CLASS,
    classIndex: Kotlin.newClassIndex(),
    simpleName: 'Panda',
    baseClasses: [Sprite]
  };
  function MainState() {
    Phaser.State.call(this);
    this.key_left$delegate = lazy(MainState$key_left$lambda(this));
    this.key_right$delegate = lazy(MainState$key_right$lambda(this));
    this.key_thrust$delegate = lazy(MainState$key_thrust$lambda(this));
  }
  Object.defineProperty(MainState.prototype, 'keyboard', {
    get: function () {
      return this.game.input.keyboard;
    }
  });
  Object.defineProperty(MainState.prototype, 'key_left', {
    get: function () {
      var $receiver = this.key_left$delegate;
      new Kotlin.PropertyMetadata('key_left');
      return $receiver.value;
    }
  });
  Object.defineProperty(MainState.prototype, 'key_right', {
    get: function () {
      var $receiver = this.key_right$delegate;
      new Kotlin.PropertyMetadata('key_right');
      return $receiver.value;
    }
  });
  Object.defineProperty(MainState.prototype, 'key_thrust', {
    get: function () {
      var $receiver = this.key_thrust$delegate;
      new Kotlin.PropertyMetadata('key_thrust');
      return $receiver.value;
    }
  });
  MainState.prototype.preload = function () {
    image(this.load, Assets_getInstance().panda);
    this.game.scale.scaleMode = Phaser.ScaleManager.SHOW_ALL;
    this.game.scale.pageAlignHorizontally = true;
    this.game.scale.pageAlignVertically = true;
    this.game.scale.refresh();
  };
  MainState.prototype.create = function () {
    this.game.add.text(10, 10, 'Hello World!', TextStyle('40px Arial', void 0, void 0, void 0, void 0, void 0, 'red'));
    this.layer1 = this.game.add.group();
    this.layer2 = this.game.add.group();
    this.layer2.scale.set(2, 2);
    for (var i = 1; i <= 10; i++) {
      this.layer1.addChild(new Panda(Math.random() * gameProperties_getInstance().screenWidth, Math.random() * gameProperties_getInstance().screenHeight));
    }
    for (var i_0 = 1; i_0 <= 10; i_0++) {
      var tmp$ = this.layer2;
      var $receiver = new Panda(Math.random() * gameProperties_getInstance().screenWidth, Math.random() * gameProperties_getInstance().screenHeight);
      $receiver.tint = 65280;
      tmp$.addChild($receiver);
    }
    var $receiver_0 = new Panda(Math.random() * gameProperties_getInstance().screenWidth, Math.random() * gameProperties_getInstance().screenHeight);
    $receiver_0.tint = 255;
    var p = $receiver_0;
  };
  MainState.prototype.update = function () {
    var tmp$, tmp$_0, tmp$_1;
    tmp$ = this.layer1;
    tmp$_0 = tmp$.x, tmp$_1 = tmp$_0, tmp$.x = tmp$_0 + 1, tmp$_1;
    this.layer2.x = this.layer2.x + 2;
    if (this.layer1.x > 100) {
      start(this.game.state, new OtherState(), void 0, void 0, []);
    }
  };
  function MainState$key_left$lambda(this$MainState) {
    return function () {
      return this$MainState.keyboard.addKey(Phaser.Keyboard.LEFT);
    };
  }
  function MainState$key_right$lambda(this$MainState) {
    return function () {
      return this$MainState.keyboard.addKey(Phaser.Keyboard.RIGHT);
    };
  }
  function MainState$key_thrust$lambda(this$MainState) {
    return function () {
      return this$MainState.keyboard.addKey(Phaser.Keyboard.UP);
    };
  }
  MainState.$metadata$ = {
    type: Kotlin.TYPE.CLASS,
    classIndex: Kotlin.newClassIndex(),
    simpleName: 'MainState',
    baseClasses: []
  };
  function OtherState() {
    Phaser.State.call(this);
    this.key_left$delegate = lazy(OtherState$key_left$lambda(this));
    this.key_right$delegate = lazy(OtherState$key_right$lambda(this));
    this.key_thrust$delegate = lazy(OtherState$key_thrust$lambda(this));
  }
  Object.defineProperty(OtherState.prototype, 'keyboard', {
    get: function () {
      return this.game.input.keyboard;
    }
  });
  Object.defineProperty(OtherState.prototype, 'key_left', {
    get: function () {
      var $receiver = this.key_left$delegate;
      new Kotlin.PropertyMetadata('key_left');
      return $receiver.value;
    }
  });
  Object.defineProperty(OtherState.prototype, 'key_right', {
    get: function () {
      var $receiver = this.key_right$delegate;
      new Kotlin.PropertyMetadata('key_right');
      return $receiver.value;
    }
  });
  Object.defineProperty(OtherState.prototype, 'key_thrust', {
    get: function () {
      var $receiver = this.key_thrust$delegate;
      new Kotlin.PropertyMetadata('key_thrust');
      return $receiver.value;
    }
  });
  OtherState.prototype.preload = function () {
    image(this.load, Assets_getInstance().panda);
  };
  OtherState.prototype.create = function () {
    this.game.add.text(10, 10, 'Hello World!', TextStyle('40px Arial', void 0, void 0, void 0, void 0, void 0, 'red'));
    var $receiver = new Panda(Math.random() * gameProperties_getInstance().screenWidth, Math.random() * gameProperties_getInstance().screenHeight);
    $receiver.tint = 255;
    $receiver.scale.set(4, 4);
    var p = $receiver;
    this.game.add.existing(p);
  };
  function OtherState$key_left$lambda(this$OtherState) {
    return function () {
      return this$OtherState.keyboard.addKey(Phaser.Keyboard.LEFT);
    };
  }
  function OtherState$key_right$lambda(this$OtherState) {
    return function () {
      return this$OtherState.keyboard.addKey(Phaser.Keyboard.RIGHT);
    };
  }
  function OtherState$key_thrust$lambda(this$OtherState) {
    return function () {
      return this$OtherState.keyboard.addKey(Phaser.Keyboard.UP);
    };
  }
  OtherState.$metadata$ = {
    type: Kotlin.TYPE.CLASS,
    classIndex: Kotlin.newClassIndex(),
    simpleName: 'OtherState',
    baseClasses: []
  };
  var phaserGame;
  function get_phaserGame() {
    return phaserGame.getValue_dsk1ci$(this, new Kotlin.PropertyMetadata('phaserGame'));
  }
  function set_phaserGame(phaserGame_0) {
    phaserGame.setValue_w32e13$(this, new Kotlin.PropertyMetadata('phaserGame'), phaserGame_0);
  }
  function Sprite(x, y, key) {
    Phaser.Sprite.call(this, get_phaserGame(), x, y, key.name);
  }
  Sprite.$metadata$ = {
    type: Kotlin.TYPE.CLASS,
    classIndex: Kotlin.newClassIndex(),
    simpleName: 'Sprite',
    baseClasses: []
  };
  function initKoala(config) {
    set_phaserGame(new Phaser.Game(config));
    return get_phaserGame();
  }
  function T$2() {
  }
  T$2.$metadata$ = {
    type: Kotlin.TYPE.TRAIT,
    classIndex: Kotlin.newClassIndex(),
    simpleName: 'T$2',
    baseClasses: []
  };
  function RGBColor() {
  }
  RGBColor.$metadata$ = {
    type: Kotlin.TYPE.TRAIT,
    classIndex: Kotlin.newClassIndex(),
    simpleName: 'RGBColor',
    baseClasses: []
  };
  function ColorComponents() {
  }
  ColorComponents.$metadata$ = {
    type: Kotlin.TYPE.TRAIT,
    classIndex: Kotlin.newClassIndex(),
    simpleName: 'ColorComponents',
    baseClasses: [RGBColor]
  };
  function CursorKeys() {
  }
  CursorKeys.$metadata$ = {
    type: Kotlin.TYPE.TRAIT,
    classIndex: Kotlin.newClassIndex(),
    simpleName: 'CursorKeys',
    baseClasses: []
  };
  function T$3() {
  }
  T$3.$metadata$ = {
    type: Kotlin.TYPE.TRAIT,
    classIndex: Kotlin.newClassIndex(),
    simpleName: 'T$3',
    baseClasses: []
  };
  function WheelEventProxy() {
  }
  WheelEventProxy.$metadata$ = {
    type: Kotlin.TYPE.TRAIT,
    classIndex: Kotlin.newClassIndex(),
    simpleName: 'WheelEventProxy',
    baseClasses: []
  };
  function T$9() {
  }
  T$9.$metadata$ = {
    type: Kotlin.TYPE.TRAIT,
    classIndex: Kotlin.newClassIndex(),
    simpleName: 'T$9',
    baseClasses: []
  };
  function T$10() {
  }
  T$10.$metadata$ = {
    type: Kotlin.TYPE.TRAIT,
    classIndex: Kotlin.newClassIndex(),
    simpleName: 'T$10',
    baseClasses: []
  };
  function T$11() {
  }
  T$11.$metadata$ = {
    type: Kotlin.TYPE.TRAIT,
    classIndex: Kotlin.newClassIndex(),
    simpleName: 'T$11',
    baseClasses: []
  };
  function T$12() {
  }
  T$12.$metadata$ = {
    type: Kotlin.TYPE.TRAIT,
    classIndex: Kotlin.newClassIndex(),
    simpleName: 'T$12',
    baseClasses: []
  };
  function PhaserTextStyle() {
  }
  PhaserTextStyle.$metadata$ = {
    type: Kotlin.TYPE.TRAIT,
    classIndex: Kotlin.newClassIndex(),
    simpleName: 'PhaserTextStyle',
    baseClasses: []
  };
  function T$13() {
  }
  T$13.$metadata$ = {
    type: Kotlin.TYPE.TRAIT,
    classIndex: Kotlin.newClassIndex(),
    simpleName: 'T$13',
    baseClasses: []
  };
  function T$14() {
  }
  T$14.$metadata$ = {
    type: Kotlin.TYPE.TRAIT,
    classIndex: Kotlin.newClassIndex(),
    simpleName: 'T$14',
    baseClasses: []
  };
  function T$15() {
  }
  T$15.$metadata$ = {
    type: Kotlin.TYPE.TRAIT,
    classIndex: Kotlin.newClassIndex(),
    simpleName: 'T$15',
    baseClasses: []
  };
  function Asset(name, url) {
    this.name = name;
    this.url = url;
  }
  Asset.$metadata$ = {
    type: Kotlin.TYPE.CLASS,
    classIndex: Kotlin.newClassIndex(),
    simpleName: 'Asset',
    baseClasses: []
  };
  Asset.prototype.component1 = function () {
    return this.name;
  };
  Asset.prototype.component2 = function () {
    return this.url;
  };
  Asset.prototype.copy_puj7f4$ = function (name, url) {
    return new Asset(name === void 0 ? this.name : name, url === void 0 ? this.url : url);
  };
  Asset.prototype.toString = function () {
    return 'Asset(name=' + Kotlin.toString(this.name) + (', url=' + Kotlin.toString(this.url)) + ')';
  };
  Asset.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.name) | 0;
    result = result * 31 + Kotlin.hashCode(this.url) | 0;
    return result;
  };
  Asset.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.name, other.name) && Kotlin.equals(this.url, other.url)))));
  };
  function start($receiver, state, clearWorld, clearCache, args) {
    if (clearWorld === void 0)
      clearWorld = null;
    if (clearCache === void 0)
      clearCache = null;
    var stateID = get_js(Kotlin.getKClassFromExpression(state)).name;
    $receiver.add(stateID, state, false);
    $receiver.start(stateID);
  }
  function GameStateType(name) {
    var tmp$;
    return Kotlin.isType(tmp$ = name, Object) ? tmp$ : Kotlin.throwCCE();
  }
  function GameState(game) {
  }
  GameState.prototype.preload = function () {
  };
  GameState.prototype.create = function () {
  };
  GameState.prototype.update = function () {
  };
  GameState.prototype.render = function () {
  };
  GameState.$metadata$ = {
    type: Kotlin.TYPE.CLASS,
    classIndex: Kotlin.newClassIndex(),
    simpleName: 'GameState',
    baseClasses: []
  };
  function TextStyle(font, fontStyle, fontVariant, fontWeight, fontSize, backgroundColor, fill, align, boundsAlignH, boundsAlignV, stroke, strokeThickness, wordWrap, wordWrapWidth, tabs) {
    if (font === void 0)
      font = null;
    if (fontStyle === void 0)
      fontStyle = null;
    if (fontVariant === void 0)
      fontVariant = null;
    if (fontWeight === void 0)
      fontWeight = null;
    if (fontSize === void 0)
      fontSize = null;
    if (backgroundColor === void 0)
      backgroundColor = null;
    if (fill === void 0)
      fill = null;
    if (align === void 0)
      align = null;
    if (boundsAlignH === void 0)
      boundsAlignH = null;
    if (boundsAlignV === void 0)
      boundsAlignV = null;
    if (stroke === void 0)
      stroke = null;
    if (strokeThickness === void 0)
      strokeThickness = null;
    if (wordWrap === void 0)
      wordWrap = null;
    if (wordWrapWidth === void 0)
      wordWrapWidth = null;
    if (tabs === void 0)
      tabs = null;
    var out = {};
    if (font != null)
      out.font = font;
    if (fontStyle != null)
      out.fontStyle = fontStyle;
    if (fontVariant != null)
      out.fontVariant = fontVariant;
    if (fontWeight != null)
      out.fontWeight = fontWeight;
    if (fontSize != null)
      out.fontSize = fontSize;
    if (backgroundColor != null)
      out.backgroundColor = backgroundColor;
    if (fill != null)
      out.fill = fill;
    if (align != null)
      out.align = align;
    if (boundsAlignH != null)
      out.boundsAlignH = boundsAlignH;
    if (boundsAlignV != null)
      out.boundsAlignV = boundsAlignV;
    if (stroke != null)
      out.stroke = stroke;
    if (strokeThickness != null)
      out.strokeThickness = strokeThickness;
    if (wordWrap != null)
      out.wordWrap = wordWrap;
    if (wordWrapWidth != null)
      out.wordWrapWidth = wordWrapWidth;
    if (tabs != null)
      out.tabs = tabs;
    return out;
  }
  function GameConfig(enableDebug, width, height, renderer, parent, transparent, antialias, resolution, preserveDrawingBuffer, physicsConfig, seed, state, forceSetTimeOut, multiTextue) {
    if (enableDebug === void 0)
      enableDebug = null;
    if (width === void 0)
      width = null;
    if (height === void 0)
      height = null;
    if (renderer === void 0)
      renderer = null;
    if (parent === void 0)
      parent = null;
    if (transparent === void 0)
      transparent = null;
    if (antialias === void 0)
      antialias = null;
    if (resolution === void 0)
      resolution = null;
    if (preserveDrawingBuffer === void 0)
      preserveDrawingBuffer = null;
    if (physicsConfig === void 0)
      physicsConfig = null;
    if (seed === void 0)
      seed = null;
    if (state === void 0)
      state = null;
    if (forceSetTimeOut === void 0)
      forceSetTimeOut = null;
    if (multiTextue === void 0)
      multiTextue = null;
    var out = {};
    if (enableDebug != null)
      out.enableDebug = enableDebug;
    if (width != null)
      out.width = width;
    if (height != null)
      out.height = height;
    if (renderer != null)
      out.renderer = renderer;
    if (parent != null)
      out.parent = parent;
    if (transparent != null)
      out.transparent = transparent;
    if (antialias != null)
      out.antialias = antialias;
    if (resolution != null)
      out.resolution = resolution;
    if (preserveDrawingBuffer != null)
      out.preserveDrawingBuffer = preserveDrawingBuffer;
    if (physicsConfig != null)
      out.physicsConfig = physicsConfig;
    if (seed != null)
      out.seed = seed;
    if (state != null)
      out.state = state;
    if (forceSetTimeOut != null)
      out.forceSetTimeOut = forceSetTimeOut;
    if (multiTextue != null)
      out.multiTextue = multiTextue;
    return out;
  }
  function image($receiver, asset) {
    return $receiver.image(asset.name, asset.url);
  }
  function images($receiver, assets) {
    var tmp$;
    for (tmp$ = 0; tmp$ !== assets.length; ++tmp$) {
      var element = assets[tmp$];
      $receiver.image(element.name, element.url);
    }
  }
  function images_0($receiver, assets) {
    var tmp$;
    tmp$ = assets.iterator();
    while (tmp$.hasNext()) {
      var element = tmp$.next();
      $receiver.image(element.name, element.url);
    }
  }
  function sound($receiver, asset) {
    return $receiver.audio(asset.name, asset.url);
  }
  function sounds($receiver, assets) {
    var tmp$;
    for (tmp$ = 0; tmp$ !== assets.length; ++tmp$) {
      var element = assets[tmp$];
      $receiver.audio(element.name, element.url);
    }
  }
  function sounds_0($receiver, assets) {
    var tmp$;
    tmp$ = assets.iterator();
    while (tmp$.hasNext()) {
      var element = tmp$.next();
      $receiver.audio(element.name, element.url);
    }
  }
  function DirectionObj() {
  }
  DirectionObj.$metadata$ = {
    type: Kotlin.TYPE.TRAIT,
    classIndex: Kotlin.newClassIndex(),
    simpleName: 'DirectionObj',
    baseClasses: []
  };
  _.main_kand9s$ = main;
  Object.defineProperty(_, 'gameProperties', {
    get: gameProperties_getInstance
  });
  Object.defineProperty(_, 'Assets', {
    get: Assets_getInstance
  });
  _.Panda = Panda;
  _.MainState = MainState;
  _.OtherState = OtherState;
  var package$Koala = _.Koala || (_.Koala = {});
  Object.defineProperty(package$Koala, 'phaserGame', {
    get: get_phaserGame,
    set: set_phaserGame
  });
  package$Koala.Sprite = Sprite;
  package$Koala.initKoala_lcgo3e$ = initKoala;
  var package$Phaser = _.Phaser || (_.Phaser = {});
  package$Phaser.T$2 = T$2;
  package$Phaser.RGBColor = RGBColor;
  package$Phaser.ColorComponents = ColorComponents;
  package$Phaser.CursorKeys = CursorKeys;
  package$Phaser.T$3 = T$3;
  package$Phaser.WheelEventProxy = WheelEventProxy;
  package$Phaser.T$9 = T$9;
  package$Phaser.T$10 = T$10;
  package$Phaser.T$11 = T$11;
  package$Phaser.T$12 = T$12;
  package$Phaser.PhaserTextStyle = PhaserTextStyle;
  package$Phaser.T$13 = T$13;
  package$Phaser.T$14 = T$14;
  package$Phaser.T$15 = T$15;
  package$Phaser.Asset = Asset;
  package$Phaser.start_6a57ie$ = start;
  package$Phaser.GameStateType_61zpoe$ = GameStateType;
  package$Phaser.GameState = GameState;
  package$Phaser.TextStyle_gqcoa5$ = TextStyle;
  package$Phaser.GameConfig_3vtut0$ = GameConfig;
  package$Phaser.image_ci216l$ = image;
  package$Phaser.images_wf56vb$ = images;
  package$Phaser.images_dslnxl$ = images_0;
  package$Phaser.sound_ci216l$ = sound;
  package$Phaser.sounds_wf56vb$ = sounds;
  package$Phaser.sounds_dslnxl$ = sounds_0;
  package$Phaser.DirectionObj = DirectionObj;
  phaserGame = properties_0.Delegates.notNull();
  Kotlin.defineModule('example1', _);
  main([]);
  return _;
}(typeof example1 === 'undefined' ? {} : example1, kotlin);
