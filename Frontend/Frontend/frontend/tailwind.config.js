/** @type {import('tailwindcss').Config} */
export default {
  content: {
    relative: true,
    files: [
      "./src/**/*.{js,ts,jsx,tsx,mdx}",
      "./book/**/*.{js,ts,jsx,tsx,mdx}",
      "./components/**/*.{js,ts,jsx,tsx,mdx}",
      "./services/**/*.{js,ts,jsx,tsx,mdx}",
      "./appointment/**/*.{js,ts,jsx,tsx,mdx}",
    ],
  },
  theme: {
    extend: {},
  },
  plugins: [],
};
