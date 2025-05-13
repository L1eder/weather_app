# Мобильное приложение "Прогноз погоды"

## Описание
Это мобильное приложение предоставляет пользователям возможность получать актуальный прогноз погоды на основе выбранного города. Приложение разработано с использованием Kotlin и Jetpack Compose, что обеспечивает современный и отзывчивый интерфейс.

## Демонстрация работы приложения

<img src="app/src/main/res/drawable/app_presentation.gif" alt="ScreenCast" width="400"/>

## Архитектура проекта
com.example.weatherapp  
├── data  
│   ├── api  
│   │   ├── ApiService.kt  
│   │   ├── CoordinatesApi.kt  
│   │   └── WeatherApi.kt  
│   ├── models  
│   │   ├── CityCoordinatesResponse.kt  
│   │   └── WeatherResponse.kt  
│   └── repositories  
│       ├── CoordinatesRepository.kt  
│       └── WeatherRepository.kt  
│  
├── domain  
│   ├── model  
│   │       
│   └── usecases  
│       ├── GetCoordinatesUseCase.kt  
│       └── GetWeatherUseCase.kt  
│
├── presentation  
│   ├── ui  
│   │   ├── components  
│   │   │    ├── CityBackground.kt    
│   │   │    ├── CityCard.kt    
│   │   │    ├── CityHeader.kt    
│   │   │    ├── CitySearchBar.kt    
│   │   │    ├── WeatherBackground.kt    
│   │   │    ├── WeatherCard.kt    
│   │   │    ├── WeatherCurrentCard.kt    
│   │   │    ├── WeatherHeader.kt    
│   │   │    ├── WeatherIcon.kt    
│   │   │    └── WeatherIsLoading.kt  
│   │   │  
│   │   └── screen  
│   │       ├── CitySelectionScreen.kt  
│   │       └── WeatherScreen.kt  
│   └── viewmodels    
│         ├── WeatherViewModel.kt    
│         └── WeatherViewModelFactory.kt    
│    
├── ui.theme  
│   └── (цвета, типографика, темы)  
│  
└── MainActivity.kt  

## Структура проекта

### 1. Data layer

#### API Интерфейсы:
- **CoordinatesApi**: Интерфейс для получения координат города.
- **WeatherApi**: Интерфейс для получения данных о погоде на основе координат.

#### Модели данных:
- **CityCoordinatesResponse**: Представляет ответ, содержащий детали о городе, такие как название, широта, долгота и т.д.
- **WeatherResponse**: Содержит ежедневные и почасовые прогнозы погоды.
- **DailyForecast** и **HourlyForecast**: Модели для ежедневных и почасовых данных о погоде.

#### Репозитории:
- **CoordinatesRepository**: Обрабатывает запросы на получение координат города из API.
- **WeatherRepository**: Обрабатывает запросы на получение данных о погоде из API.

### 2. Domain layer

#### Usecases:
- **GetCoordinatesUseCase**: Получает координаты для заданного названия города.
- **GetWeatherUseCase**: Получает данные о погоде на основе широты и долготы.

### 3. UI layer

#### ViewModel:
- **WeatherViewModel**: Управляет данными, связанными с пользовательским интерфейсом, с учетом жизненного цикла. Получает данные о погоде при выборе города и предоставляет их интерфейсу.

#### UI Компоненты:
- **WeatherCard**: Отображает индивидуальную информацию о погоде для конкретной даты.
- **WeatherDropdownMenu**: Позволяет пользователям выбрать город из выпадающего списка.
- **WeatherScreen**: Основной экран, который объединяет выпадающее меню и отображает информацию о погоде с помощью карточек.

### 4. MainActivity
Точка входа в приложение, где инициализируются зависимости, включая репозитории и используемые случаи. ViewModel создается с использованием паттерна фабрики для передачи зависимостей.

## Ключевые особенности
- **Выбор города**: Пользователи могут выбрать город из выпадающего меню для получения его данных о погоде.
- **Состояние загрузки**: Отображает текст загрузки во время получения данных.
- **Обработка ошибок**: Логирует ошибки в случае неудачи при получении координат или данных о погоде.
- **Отображение погоды на ближайшие две недели**: Пользователь может увидеть погоду на ближайшие 14 дней. 


