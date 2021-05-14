const state = {

  userInfo: JSON.parse(localStorage.getItem("userInfo")) || {},

}

const mutations = {
  setLoginIn: ( state, payload ) => {
    state.userInfo = payload;
  },
  setLoginOut: ( state ) => {
    state.userInfo = {username: null};
  },
}

const actions = {
  signIn({ commit }, { payload }) {
    if( payload ) delete payload.password;
    localStorage.setItem("userInfo", JSON.stringify(payload));
    commit("setLoginIn", payload);
  },
  signOut({ commit }) {
    localStorage.removeItem("userInfo");
    commit("setLoginOut")
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}