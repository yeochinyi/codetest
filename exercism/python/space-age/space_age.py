import functools
class SpaceAge:

    # def __init__(self, seconds):
        # self.year = seconds / 31557600
    # def on_earth(self):
        # return round(self.year, 2)
    # def on_venus(self):
        # return round(self.year/0.61519726, 2)
    # def on_mercury(self):
        # return round(self.year/0.2408467 , 2)
    # def on_mars(self):
        # return round(self.year/1.8808158, 2)
    # def on_jupiter(self):
        # return round(self.year/11.862615, 2)
    # def on_saturn(self):
        # return round(self.year/29.447498, 2)
    # def on_neptune(self):
        # return round(self.year/164.79132, 2)
    # def on_uranus(self):
        # return round(self.year/84.016846, 2)

    # One Earth year, in seconds
    # EARTH_YEAR = 31557600
    # Orbital periods of planets, in Earth years
    # ORBITS = {
        # 'mercury': 0.2408467,
        # 'venus': 0.61519726,
        # 'earth': 1.0,
        # 'mars': 1.8808158,
        # 'jupiter': 11.862615,
        # 'saturn': 29.447498,
        # 'uranus': 84.016846,
        # 'neptune': 164.79132,
    # }
    # def __init__(self, seconds):
        # self.seconds = seconds
    # def _get_years(self, orbital_period):
        # """
        # Get the number of years in the given orbital period
        # """
        # return round(self.seconds / (self.EARTH_YEAR * orbital_period), 2)
    # def __getattr__(self, name):
        # # Supply an implementation for on_<planet> based on _get_years
        # # for each planet in ORBITS
        # if name.startswith('on_'):
            # planet = name[3:]
            # if planet in self.ORBITS:
                # return functools.partial(self._get_years, self.ORBITS[planet])
        # raise AttributeError


    _base_period = 365.25 * 60 * 60 * 24
    _periods = (
        ("earth", 1.0),
        ("mercury", 0.2408467),
        ("venus", 0.61519726),
        ("mars", 1.8808158),
        ("jupiter", 11.862615),
        ("saturn", 29.447498),
        ("uranus", 84.016846),
        ("neptune", 164.79132),
    )    
    def __init__(self, seconds):
        self.seconds = seconds
    def _calc(self, period):
        return round(self.seconds / (self._base_period * period), 2)

    @classmethod
    def _init_class(cls):
        for name, period in cls._periods:
            cls._add_period_method(name, period)   

    @classmethod
    def _add_period_method(cls, name, period):
        def on_body(self):
            return self._calc(period)
        on_body.__name__ = "on_{name}".format(name=name)
        setattr(cls, on_body.__name__, on_body)     

SpaceAge._init_class()

